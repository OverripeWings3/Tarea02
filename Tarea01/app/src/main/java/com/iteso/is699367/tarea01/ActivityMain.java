package com.iteso.is699367.tarea01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.iteso.is699367.tarea01.Utils.Alumno;

public class ActivityMain extends AppCompatActivity {

    private Spinner spinner;
    private AutoCompleteTextView books;
    private EditText name;
    private EditText phone;
    private Button clean;
    private CheckBox deporte;
    private RadioButton fem;
    private RadioButton mas;
    private Alumno alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.activity_main_name);
        phone = findViewById(R.id.activity_main_phone);
        spinner = findViewById(R.id.activity_main_spinner);
        fem = findViewById(R.id.activity_main_fem);
        mas = findViewById(R.id.activity_main_mas);
        books = findViewById(R.id.activity_main_autocomplete);
        deporte = findViewById(R.id.activity_main_checkbox);
        clean =  findViewById(R.id.activity_main_clean);
        alumno = new Alumno();

        ArrayAdapter<CharSequence> adapterGrade = ArrayAdapter
                .createFromResource(this, R.array.grade_array,
                        R.layout.support_simple_spinner_dropdown_item);

        adapterGrade.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapterGrade);

        String[] booksArray = getResources().getStringArray(R.array.book_array);

        ArrayAdapter<String> adapterBooks = new
                ArrayAdapter<>(this, android.R.layout.simple_list_item_1, booksArray);

        books.setAdapter(adapterBooks);

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                builder.setMessage(getResources().getString(R.string.alert_clean))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                clean();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }

    public void save() {
        if(name.getText().toString().equals("") || phone.getText().toString().equals("")) {
            Toast.makeText(ActivityMain.this,
                    "Completa todos los campos", Toast.LENGTH_LONG).show();
        }
        else {
            alumno.name = name.getText().toString();
            alumno.phone = phone.getText().toString();
            alumno.grade = spinner.getSelectedItem().toString();
            alumno.faveBook = books.getText().toString();
            Toast.makeText(ActivityMain.this, alumno.toString(), Toast.LENGTH_LONG).show();
            clean();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_main_save:
                save();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.activity_main_fem:
                if (checked) {
                    alumno.gender = "Femenino";
                }
                    break;
            case R.id.activity_main_mas:
                if (checked) {
                    alumno.gender = "Masculino";
                }
                    break;
        }
    }


    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.activity_main_checkbox:
                if (checked) {
                    alumno.sport = "Sí";
                } else {
                    alumno.sport = "No";
                }
                break;
        }
    }

    public void clean() {
        name.setText("");
        phone.setText("");
        fem.setChecked(false);
        mas.setChecked(false);
        books.setText("");
        deporte.setChecked(false);

    }

}

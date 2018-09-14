package com.iteso.is699367.tarea02;

import android.annotation.SuppressLint;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    private Button small, medium, large, exLarge, addCart;
    private ImageButton like;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        small = findViewById(R.id.activity_main_small);
        medium = findViewById(R.id.activity_main_medium);
        large = findViewById(R.id.activity_main_large);
        exLarge = findViewById(R.id.activity_main_extra_large);
        addCart = findViewById(R.id.activity_main_add_cart);
        like = findViewById(R.id.activity_main_like);


        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityMain.this,
                        getResources().getText(R.string.like_toast),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        final ScrollView scrollView = findViewById(R.id.activity_main_scroll);
        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(addCart.getText().equals(getText(R.string.added_cart))) {
                    Toast.makeText(ActivityMain.this,
                            "Already Added to Cart!",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    addCart.setText(getResources().getText(R.string.added_cart));
                    Snackbar.make(scrollView,
                            getResources().getText(R.string.added_cart),
                            Snackbar.LENGTH_INDEFINITE)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    addCart.setText(getResources().getText(R.string.add_cart));
                                    addCart.setSelected(false);
                                }
                            }).show();
                    addCart.setSelected(true);
                }
            }
        });

    }


    public void onRadioButtonOnClicked(View v) {
        switch (v.getId()) {
            case R.id.activity_main_color_gray:
                break;
            case R.id.activity_main_color_pink:
                break;
            case R.id.activity_main_color_brown:
                break;
            case R.id.activity_main_color_black:
                break;
            default:
                break;
        }
    }


    public void onSizeClicked(View view) {
        switch(view.getId()) {
            case R.id.activity_main_small:
                view.setSelected(true);
                medium.setSelected(false);
                large.setSelected(false);
                exLarge.setSelected(false);
                medium.setTextColor(getColor(R.color.colorPrimary));
                large.setTextColor(getColor(R.color.colorPrimary));
                exLarge.setTextColor(getColor(R.color.colorPrimary));
                small.setTextColor(getColor(android.R.color.white));
                break;
            case R.id.activity_main_medium:
                view.setSelected(true);
                small.setSelected(false);
                large.setSelected(false);
                exLarge.setSelected(false);
                small.setTextColor(getColor(R.color.colorPrimary));
                large.setTextColor(getColor(R.color.colorPrimary));
                exLarge.setTextColor(getColor(R.color.colorPrimary));
                medium.setTextColor(getColor(android.R.color.white));
                break;
            case R.id.activity_main_large:
                view.setSelected(true);
                small.setSelected(false);
                medium.setSelected(false);
                exLarge.setSelected(false);
                small.setTextColor(getColor(R.color.colorPrimary));
                medium.setTextColor(getColor(R.color.colorPrimary));
                exLarge.setTextColor(getColor(R.color.colorPrimary));
                large.setTextColor(getColor(android.R.color.white));
                break;
            case R.id.activity_main_extra_large:
                view.setSelected(true);
                small.setSelected(false);
                large.setSelected(false);
                medium.setSelected(false);
                small.setTextColor(getColor(R.color.colorPrimary));
                large.setTextColor(getColor(R.color.colorPrimary));
                medium.setTextColor(getColor(R.color.colorPrimary));
                exLarge.setTextColor(getColor(android.R.color.white));
                break;
        }
    }
}

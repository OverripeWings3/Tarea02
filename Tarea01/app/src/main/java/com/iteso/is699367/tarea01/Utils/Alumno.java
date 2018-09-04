package com.iteso.is699367.tarea01.Utils;

public class Alumno {

    public String name;
    public String phone;
    public String grade;
    public String gender;
    public String faveBook;
    public String sport;

    public Alumno(){}

    public String toString() {
        return new StringBuilder()
                .append("Nombre: " + name)
                .append("\nPhone: " + phone)
                .append("\nEscolaridad: " + grade)
                .append("\nGénero: " + gender)
                .append("\nLibro Favorito: " + faveBook)
                .append("\nPractica Deporte: " + sport).toString();
    }
}

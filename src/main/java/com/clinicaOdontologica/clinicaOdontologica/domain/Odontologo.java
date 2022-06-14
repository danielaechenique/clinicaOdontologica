package com.clinicaOdontologica.clinicaOdontologica.domain;

import java.util.Objects;

public class Odontologo {
    private long id;
    private String nombre;
    private String apellido;
    private String matricula;

    //Constructor
    public Odontologo(long id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo() {

    }

    //Getters and Setters
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo" +
                "\n\tNombre: '" + nombre + '\'' +
                "\n\tApellido: '" + apellido + '\'' +
                "\n\tMatricula: " + matricula;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, matricula);
    }
}

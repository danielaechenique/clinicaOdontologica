package com.clinicaOdontologica.clinicaOdontologica.domain;

import java.sql.Date;

public class Paciente {
    private long id;
    private String apellido;
    private String nombre;
    private String dni;
    private Date fechaDeAlta;
    private Domicilio domicilio;

    public Paciente(long id, String apellido, String nombre, String dni, Date fechaDeAlta) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
    }

    public Paciente(String apellido, String nombre, String dni, Date fechaDeAlta) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
    }

    public Paciente(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaeDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }
}

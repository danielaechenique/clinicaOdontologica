package com.clinicaOdontologica.clinicaOdontologica.model;

import java.sql.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return id == paciente.id && apellido.equals(paciente.apellido) && nombre.equals(paciente.nombre) && dni.equals(paciente.dni) && fechaDeAlta.equals(paciente.fechaDeAlta) && domicilio.equals(paciente.domicilio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellido, nombre, dni, fechaDeAlta, domicilio);
    }

    @Override
    public String toString() {
        String informacion = "Paciente" +
                "\n\tNombre: '" + nombre + '\'' +
                "\n\tApellido: '" + apellido + '\'' +
                "\n\tDNI: " + dni +
                "\n\tFecha de Ingreso: " + fechaDeAlta;
        /*if (domicilio != null &&
                domicilio.getCalle() != null && domicilio.getNumero() != null &&
                domicilio.getLocalidad() != null && domicilio.getProvincia() != null) {
            informacion += domicilio.toString();
        }*/
        return informacion;
    }
}

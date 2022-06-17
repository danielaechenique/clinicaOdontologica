package com.clinicaOdontologica.clinicaOdontologica.model;

import java.util.Objects;

public class Domicilio {
    private Integer id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public Domicilio(int id, String calle, int numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio() {
    }

    public Domicilio(int id) {
        this.id = id;
    }

    public Domicilio(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return id == (domicilio.id) &&
                Objects.equals(calle, domicilio.calle) &&
                Objects.equals(numero, domicilio.numero) &&
                Objects.equals(localidad, domicilio.localidad) &&
                Objects.equals(provincia, domicilio.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calle, numero, localidad, provincia);
    }

    @Override
    public String toString() {
        return "\n\tDomicilio:" +
                "\n\t\tCalle: '" + calle + '\'' +
                "\n\t\tNumero: '" + numero + '\'' +
                "\n\t\tLocalidad: " + localidad +
                "\n\t\tProvincia: " + provincia;
    }
}

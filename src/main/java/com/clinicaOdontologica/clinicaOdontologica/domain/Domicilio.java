package com.clinicaOdontologica.clinicaOdontologica.domain;

public class Domicilio {
    private int id;
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
}

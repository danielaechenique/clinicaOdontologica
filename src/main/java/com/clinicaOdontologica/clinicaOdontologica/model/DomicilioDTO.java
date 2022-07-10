package com.clinicaOdontologica.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {
    private Integer id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public DomicilioDTO() {
    }

    public DomicilioDTO(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}

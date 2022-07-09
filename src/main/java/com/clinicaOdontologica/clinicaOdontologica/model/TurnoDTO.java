package com.clinicaOdontologica.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

//@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private Long id;
    private String turno;
    //private String npaciente;
    //private String nodontologo;
    //private LocalDateTime turno;
    private Paciente paciente;
    private Odontologo odontologo;

    public TurnoDTO() {
    }

    /*@SuppressWarnings("unchecked")
    @JsonProperty("paciente")
    private void unpackedPaciente(Map<String, Object> paciente){
        this.npaciente = (String) paciente.get("nombre");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("odontologo")
    private void unpackedOdontologo(Map<String, Object> odontologo){
        this.nodontologo = (String) odontologo.get("nombre");
    }*/
}

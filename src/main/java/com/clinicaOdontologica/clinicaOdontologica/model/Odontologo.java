package com.clinicaOdontologica.clinicaOdontologica.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter @Setter
public class Odontologo {

    @Id
    //@SequenceGenerator()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String apellido;
    private String matricula;

    public Odontologo(Long id, String nombre, String apellido, String matricula, Set<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turnos = turnos;
    }
    public Odontologo(){
    }

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;

}

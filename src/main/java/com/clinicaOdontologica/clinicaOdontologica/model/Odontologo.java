package com.clinicaOdontologica.clinicaOdontologica.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter @Setter
public class Odontologo {

    @Id
    //@SequenceGenerator()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    //@Column (name = "nombre") Podria agregarlo si quisiera cambiar el nombre de la columna, si no va a crearla por defecto con el nombre del atributo
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

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)//, cascade = CascadeType.ALL)
    @JsonIgnore //para no generar bucle infinito recursividad
    private Set<Turno> turnos = new HashSet<>();

}

package com.clinicaOdontologica.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pacientes")
@Getter @Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaDeAlta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY) //, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();
}

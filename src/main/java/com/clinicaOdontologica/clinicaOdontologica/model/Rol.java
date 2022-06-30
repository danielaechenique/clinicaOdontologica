package com.clinicaOdontologica.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
package com.clinicaOdontologica.clinicaOdontologica.repository.impl;
import com.clinicaOdontologica.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.clinicaOdontologica.repository.IRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OdontologoListRepository implements IRepository<Odontologo>{
    private List<Odontologo> odontologos;

    public OdontologoListRepository(){
        this.odontologos = cargarOdontologos();
    }

    private List<Odontologo> cargarOdontologos(){
        return new ArrayList<Odontologo>(Arrays.asList(new Odontologo(1,"juana" , "larosa","123wer"),new Odontologo(2, "Pedro","Caster","234ert")));
    }

    @Override
    public List<Odontologo> buscarTodas() {
        return this.odontologos;
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        this.odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        eliminar(odontologo.getId());
        agregar(odontologo);
        return null;
    }

    @Override
    public Boolean eliminar(Long id) {
        return odontologos.removeIf(odontologo -> odontologo.getId() == (id));
    }

    @Override
    public Odontologo buscar(Long id) {
        for(Odontologo odontologo : odontologos){
            if(odontologo.getId() == (id)){
                return odontologo;
            }
        }
        return null;
        //return odontologos.stream().filter(odontologo -> odontologo.getId()==(id)).findFirst().orElseGet(null);
    }
}

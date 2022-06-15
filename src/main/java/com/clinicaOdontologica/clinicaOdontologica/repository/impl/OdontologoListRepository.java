package com.clinicaOdontologica.clinicaOdontologica.repository.impl;

import com.clinicaOdontologica.clinicaOdontologica.domain.Odontologo;
import com.clinicaOdontologica.clinicaOdontologica.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class OdontologoListRepository implements IRepository<Odontologo>{
    private List<Odontologo> listado = agregarYListar();

    @Override
    public List<Odontologo> agregarYListar() {
        List<Odontologo> listado = new ArrayList<>();
        listado.add(new Odontologo(1, "ana", "molina", "matricula12"));
        listado.add(new Odontologo(2,"flor", "holgado", "matricula34"));
        listado.add(new Odontologo(3,"dani", "echeniqueo", "matricula45"));
        return listado;
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        this.listado.add(odontologo);
        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        eliminar(odontologo.getId());
        agregar(odontologo);
        return null;
    }

    @Override
    public Boolean eliminar(Long id) {
        return listado.removeIf(odontologo -> odontologo.getId() == (id));
    }

    @Override
    public Odontologo buscar(Long id) {
        for(Odontologo odontologo : listado){
            if(odontologo.getId() == (id)){
                return odontologo;
            }
        }
        return null;
        //return listado.stream().filter(odontologo -> odontologo.getId()==(id)).findFirst().orElseGet(null);
    }
}

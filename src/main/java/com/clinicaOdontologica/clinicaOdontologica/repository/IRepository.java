package com.clinicaOdontologica.clinicaOdontologica.repository;

import java.util.List;

public interface IRepository<T>{
    List<T> buscarTodas();
    T agregar(T t);
    T actualizar(T t);
    Boolean eliminar (Integer id);
    T buscar (Integer id);

}

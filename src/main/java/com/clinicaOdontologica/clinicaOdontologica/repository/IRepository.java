package com.clinicaOdontologica.clinicaOdontologica.repository;

import java.util.List;

public interface IRepository<T>{
    List<T> agregarYListar();
    T agregar(T t);
    T actualizar(T t);
    Boolean eliminar (Long id);
    T buscar (Long id);

}

package com.clinicaOdontologica.clinicaOdontologica.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    public T guardar (T t) throws Exception;
    public T buscarPorId(Long id) throws SQLException, Exception;
    public List<T> buscarTodos() throws SQLException;
    public void eliminar (Long id) throws SQLException;
}

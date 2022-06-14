package com.clinicaOdontologica.clinicaOdontologica.DAO.impl;

import com.clinicaOdontologica.clinicaOdontologica.DAO.ConfiguracionJDBC;
import com.clinicaOdontologica.clinicaOdontologica.DAO.IDao;
import com.clinicaOdontologica.clinicaOdontologica.domain.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private ConfiguracionJDBC configuracionJDBC;

    public OdontologoDaoH2() {
        configuracionJDBC = new ConfiguracionJDBC();
    }

    public OdontologoDaoH2(ConfiguracionJDBC configuracionJDBC) throws Exception {
        if (configuracionJDBC == null) {
            throw new Exception("Sin configuracion de JDBC");
        }
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) throws Exception {
        logger.debug("Iniciando metodo 'guardar()'");
        if (odontologo == null) throw new Exception("El odontologo no puede ser vacio");
        //Establece una coneccion
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO odontologos VALUES(?,?,?,?)");
        ;
        preparedStatement.setLong(1, odontologo.getId());
        preparedStatement.setString(2, odontologo.getNombre());
        preparedStatement.setString(3, odontologo.getApellido());
        preparedStatement.setString(4, odontologo.getMatricula());

        // Ejecutar la sentenia
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del método guardar() con exito");
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Long id) throws SQLException, Exception {
        //logger.debug("Iniciando metodo 'buscarPorId()'");
        if (id == null) throw new Exception("El id no puede ser nulo");

        Connection connection = configuracionJDBC.obtenerConexionConBD();

        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id=?");
        preparedStatement.setLong(1, id);

        // Ejecutar la sentencia
        ResultSet resultado = preparedStatement.executeQuery();

        Odontologo odontologo = new Odontologo();

        // Evaluar los resultados
        if (resultado.next()) {
            odontologo.setId(resultado.getLong("id"));
            odontologo.setNombre(resultado.getString("nombre"));
            odontologo.setApellido(resultado.getString("apellido"));
            odontologo.setMatricula(resultado.getString("matricula"));
        } else {
            throw new Exception("No existe ningun odontologo con ese ID");
        }

        resultado.close();
        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del metodo 'bucarPorId()' con exito");
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() throws SQLException {
        logger.debug("Iniciando metodo 'buscarTodos()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();

        List<Odontologo> odontologos = new ArrayList<>();

        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");

        // Ejecutar la sentencia
        ResultSet resultado = preparedStatement.executeQuery();

        // Evaluar los resultados
        while (resultado.next()) {
            Long idOdontologo = resultado.getLong("id");
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("apellido");
            String matricula = resultado.getString("matricula");

            Odontologo odontologo = new Odontologo(idOdontologo, nombre, apellido, matricula);

            odontologos.add(odontologo);
        }
        resultado.close();
        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del metodo 'consultarTodos()' con exito");
        return odontologos;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
       // logger.debug("Iniciando metodo 'eliminar()'");
        //Crear una conexion
        Connection connection = configuracionJDBC.obtenerConexionConBD();

        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM odontologos where id=?");
        preparedStatement.setLong(1, id);

        // Ejecutar la sentenia
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del metodo 'elimina()' con exito");
    }
}

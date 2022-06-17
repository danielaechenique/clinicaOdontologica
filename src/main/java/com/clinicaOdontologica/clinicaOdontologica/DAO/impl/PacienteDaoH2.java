package com.clinicaOdontologica.clinicaOdontologica.DAO.impl;

import com.clinicaOdontologica.clinicaOdontologica.DAO.ConfiguracionJDBC;
import com.clinicaOdontologica.clinicaOdontologica.DAO.IDao;
import com.clinicaOdontologica.clinicaOdontologica.domain.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class PacienteDaoH2 implements IDao<Paciente> {
    private Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private ConfiguracionJDBC configuracionJDBC;

    public PacienteDaoH2() {
        configuracionJDBC = new ConfiguracionJDBC();
    }

    public PacienteDaoH2(ConfiguracionJDBC configuracionJDBC) throws Exception {
        if (configuracionJDBC == null) {
            throw new Exception("Sin configuracion de JDBC");
        }
        this.configuracionJDBC = configuracionJDBC;
    }

    @Override
    public Paciente guardar(Paciente paciente) throws Exception {
        logger.debug("Iniciando metodo 'guardar()'");
        if (paciente == null) throw new Exception("El paciente no puede ser vacio");
        //Establece una coneccion
        Connection connection = configuracionJDBC.obtenerConexionConBD();
        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pacientes VALUES(?,?,?,?,?)");
        ;
        preparedStatement.setLong(1, paciente.getId());
        preparedStatement.setString(2, paciente.getApellido());
        preparedStatement.setString(3, paciente.getNombre());
        preparedStatement.setString(5, paciente.getDni());
        preparedStatement.setDate(6, paciente.getFechaDeAlta());

        // Ejecutar la sentenia
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del método guardar() con exito");
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Long id) throws SQLException, Exception {
        logger.debug("Iniciando metodo 'buscarPorId()'");
        if (id == null) throw new Exception("El id no puede ser nulo");

        Connection connection = configuracionJDBC.obtenerConexionConBD();

        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE id=?");
        preparedStatement.setLong(1, id);

        // Ejecutar la sentencia
        ResultSet resultado = preparedStatement.executeQuery();

        Paciente paciente = new Paciente();

        // Evaluar los resultados
        if (resultado.next()) {
            paciente.setId(resultado.getLong("id"));
            paciente.setApellido(resultado.getString("apellido"));
            paciente.setNombre(resultado.getString("nombre"));
            paciente.setDni(resultado.getString("dni"));
            paciente.setFechaeDeAlta(resultado.getDate("fechaDeAlta"));
        } else {
            throw new Exception("No existe ningun odontologo con ese ID");
        }

        resultado.close();
        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del metodo 'bucarPorId()' con exito");
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() throws SQLException {
        logger.debug("Iniciando metodo 'buscarTodos()'");
        Connection connection = configuracionJDBC.obtenerConexionConBD();

        List<Paciente> pacientes = new ArrayList<>();

        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");

        // Ejecutar la sentencia
        ResultSet resultado = preparedStatement.executeQuery();

        // Evaluar los resultados
        while (resultado.next()) {
            Long idPaciente = resultado.getLong("id");
            String apellido = resultado.getString("apellido");
            String nombre = resultado.getString("nombre");
            String dni = resultado.getString("dni");
            Date fechaDeAlta = resultado.getDate("fechaDeAlta");

            Paciente paciente = new Paciente(idPaciente, apellido, nombre, dni, fechaDeAlta);

            pacientes.add(paciente);
        }
        resultado.close();
        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del metodo 'consultarTodos()' con exito");
        return pacientes;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        logger.debug("Iniciando metodo 'eliminar()'");
        //Crear una conexion
        Connection connection = configuracionJDBC.obtenerConexionConBD();

        // Crear una sentencia
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM pacientes where id=?");
        preparedStatement.setLong(1, id);

        // Ejecutar la sentenia
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

        logger.debug("Termino la ejecucion del metodo 'eliminar()' con exito");
    }
}

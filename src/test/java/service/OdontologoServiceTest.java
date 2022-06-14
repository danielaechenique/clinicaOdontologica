package service;

import com.clinicaOdontologica.clinicaOdontologica.domain.Odontologo;
import com.clinicaOdontologica.clinicaOdontologica.service.OdontologoService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OdontologoServiceTest {
    /*private OdontologoService odontologoService;

    @BeforeEach
    public void reset() throws Exception {
        odontologoService = new OdontologoService();
    }
    @BeforeAll
    public static void init() {
        PropertyConfigurator.configure("log4j.properties");
    }


    @Test
    public void guardarOdontologo() {
        Odontologo odontologo = new Odontologo("dani", "eche", "123qwe");
        String respuestaEsperada = "El odontologo " + odontologo + " fue guardado con exito";

        String respuestaObtenida = odontologoService.guardar("dani", "eche", "123qwe");

        assertEquals(respuestaEsperada, respuestaObtenida);
    }
    @Test
    public void consultarTodos() {
        String respuestaNoEsperada = "No hay odontologos";
        String respuestaObtenida = odontologoService.buscarTodos();

        assertNotEquals(respuestaNoEsperada, respuestaObtenida);
    }*/
}

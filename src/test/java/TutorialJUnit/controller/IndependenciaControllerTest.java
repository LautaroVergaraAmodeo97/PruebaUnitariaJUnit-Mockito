package TutorialJUnit.controller;

import TutorialJUnit.models.Pais;
import TutorialJUnit.models.PaisResponse;
import TutorialJUnit.repositories.PaisRepositorio;
import TutorialJUnit.util.DiferenciaEntreFechas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

class IndependenciaControllerTest {

    @Autowired
    PaisResponse paisResponse;
    @Autowired
    Optional<Pais>pais;

    PaisRepositorio paisRepositorioMock = Mockito.mock(PaisRepositorio.class);

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas;

    @Autowired
    IndependenciaControlador independenciaControlador = new IndependenciaControlador(paisRepositorioMock,diferenciaEntreFechas);

    //Antes
    @BeforeEach
        void setUp(){

        Pais mockPais = new Pais();
        mockPais.setCodigo("DO");
        mockPais.setIndependencia("27/02/1844");
        mockPais.setPaisId((long) 1);
        mockPais.setNombre_pais("Republica Dominicana");
        mockPais.setCapital_pais("Santo Domingo");

        Mockito.when(paisRepositorioMock.findPaisByCodigo("DO")).thenReturn(mockPais);

    }

    @Test
    void getPaisValido(){
        ResponseEntity<PaisResponse> respuestaServicio;
        respuestaServicio = independenciaControlador.getPaisDetalles("DO");

        Assertions.assertEquals("Republica Dominicana",respuestaServicio.getBody().getNombre_pais());
    }

    @Test
    void getPaisInvalido(){
        ResponseEntity<PaisResponse> respuestaServicio;
        respuestaServicio = independenciaControlador.getPaisDetalles("IT");
        Assertions.assertNull(respuestaServicio.getBody().getNombre_pais());
    }
}
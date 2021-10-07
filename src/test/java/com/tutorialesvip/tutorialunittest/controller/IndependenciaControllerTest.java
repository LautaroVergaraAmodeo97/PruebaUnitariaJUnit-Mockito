package com.tutorialesvip.tutorialunittest.controller;

import com.tutorialesvip.tutorialunittest.models.Pais;
import com.tutorialesvip.tutorialunittest.models.PaisResponse;
import com.tutorialesvip.tutorialunittest.repositories.PaisRepositorio;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;
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

    PaisRepositorio paisRepositorio;

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas;

    @Autowired
    IndependenciaControlador independenciaControlador;

    @BeforeEach
    void setUp(){
        Pais mockPais = new Pais();
        mockPais.setCodigo("AR");
        mockPais.setIndependencia("09/07/1816");
        mockPais.setPaisIdId((long) 1);
        mockPais.setNombre_pais("Argentina");
        mockPais.setCapital_pais("Ciudad Autónoma de Buenos Aires");

        Mockito.when(paisRepositorio.findPaisByCodigo("AR")).thenReturn(mockPais);

    }

    @Test
    void getPaisValido(){
        ResponseEntity<PaisResponse> respuestaServicio;
        respuestaServicio = independenciaControlador.getPaisDetalles("AR");
        Assertions.assertEquals("Argentina",respuestaServicio.getBody());
    }

    @Test
    void getPaisInvalido(){
        ResponseEntity<PaisResponse> respuestaServicio;
        respuestaServicio = independenciaControlador.getPaisDetalles("BR");
        Assertions.assertNull(respuestaServicio.getBody().getNombre_pais());
    }
}
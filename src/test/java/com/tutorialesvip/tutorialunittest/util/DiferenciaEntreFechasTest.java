package com.tutorialesvip.tutorialunittest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class DiferenciaEntreFechasTest {


    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas;

    @Test
    void calculateYearsOfIndependency() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        String fechaIndependencia = "09/07/1816";

        Period resultado = diferenciaEntreFechas.calcularAniosDeIndependencia(fechaIndependencia);

        Assertions.assertEquals(3,resultado.getMonths() );
        Assertions.assertEquals(4,resultado.getDays() );
        Assertions.assertEquals(205,resultado.getYears() );
    }
}
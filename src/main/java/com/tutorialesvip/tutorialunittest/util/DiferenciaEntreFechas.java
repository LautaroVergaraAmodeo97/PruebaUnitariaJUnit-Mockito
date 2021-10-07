package com.tutorialesvip.tutorialunittest.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
public class DiferenciaEntreFechas {

    public Period calcularAniosDeIndependencia (String anioIndependencia){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        LocalDate localDate = LocalDate.parse(anioIndependencia,formatter);
        LocalDate today = LocalDate.now();

        return Period.between(localDate,today);
    }
}
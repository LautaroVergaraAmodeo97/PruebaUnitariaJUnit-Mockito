package TutorialJUnit.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Period;

class DiferenciaEntreFechasTest {


    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas;

    @Test
    void calculateYearsOfIndependency() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        String fechaIndependencia = "27/02/1844";

        Period resultado = diferenciaEntreFechas.calcularAniosDeIndependencia(fechaIndependencia);
      //  System.out.println(resultado.getDays());
      //  System.out.println(resultado.getMonths());
      //  System.out.println(resultado.getYears());
        Assertions.assertEquals(11,resultado.getDays() );
        Assertions.assertEquals(7,resultado.getMonths() );
        Assertions.assertEquals(177,resultado.getYears() );
    }
}
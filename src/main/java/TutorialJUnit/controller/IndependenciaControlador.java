package TutorialJUnit.controller;

import TutorialJUnit.repositories.PaisRepositorio;
import TutorialJUnit.models.Pais;
import TutorialJUnit.models.PaisResponse;
import TutorialJUnit.util.DiferenciaEntreFechas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.Optional;


@RestController()
public class IndependenciaControlador {

    PaisResponse paisResponse;
    Optional<Pais> pais;
    PaisRepositorio paisRepositorio;
    DiferenciaEntreFechas diferenciaEntreFechas;

    public IndependenciaControlador(PaisRepositorio paisRepositorio,DiferenciaEntreFechas diferenciaEntreFechas) {
        this.paisRepositorio = paisRepositorio;
        this.diferenciaEntreFechas = diferenciaEntreFechas;
    }

    @GetMapping(path = "/pais/{paisId}")
    public ResponseEntity<PaisResponse> getPaisDetalles(@PathVariable("paisId") String paisId) {
        pais = Optional.of(new Pais());
        paisResponse = new PaisResponse();

        pais = Optional.ofNullable(paisRepositorio.findPaisByCodigo(paisId.toUpperCase()));

        if (pais.isPresent()) {
            Period period = diferenciaEntreFechas.calcularAniosDeIndependencia(pais.get().getIndependencia());
            paisResponse.setNombre_pais(pais.get().getNombre_pais());
            paisResponse.setCapital_pais(pais.get().getCapital_pais());
            paisResponse.setIndependencia(pais.get().getIndependencia());
            paisResponse.setDiaindependencia(period.getDays());
            paisResponse.setMesindependencia(period.getMonths());
            paisResponse.setAnioindependencia(period.getYears());
        }
        return ResponseEntity.ok(paisResponse);

    }
}
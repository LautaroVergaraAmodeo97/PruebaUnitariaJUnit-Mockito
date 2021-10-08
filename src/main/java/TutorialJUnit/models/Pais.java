package TutorialJUnit.models;

import javax.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="pais_id")
    private Long paisId;
    @Column(name="nombre_pais")
    private String nombre_pais;
    @Column(name="capital_pais")
    private String capital_pais;
    @Column(name="independencia")
    private String independencia;
    @Column(name ="codigo")
    private String codigo;

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getCapital_pais() {
        return capital_pais;
    }

    public void setCapital_pais(String countryCapital) {
        this.capital_pais = capital_pais;
    }

    public String getIndependencia() {
        return independencia;
    }

    public void setIndependencia(String independencia) {
        this.independencia = independencia;
    }

}

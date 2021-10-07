package TutorialJUnit.models;

public class PaisResponse {
    private String nombre_pais;
    private String capital_pais;
    private String independencia;
    private int anioindependencia;
    private int mesindependencia;
    private int diaindependencia;

    public String getNombre_pais(){return nombre_pais;}

    public void setNombre_pais(String nombre_pais){this.nombre_pais=nombre_pais;}

    public void setCapital_pais(String capital_pais){this.capital_pais=capital_pais;}

    public void setIndependencia(String independencia){this.independencia=independencia;}

    public void setAnioindependencia(int anioindependencia){this.anioindependencia= anioindependencia;}

    public void setMesindependencia(int mesindependencia){this.mesindependencia=mesindependencia;}

    public void setDiaindependencia(int diaindependencia){this.diaindependencia=diaindependencia;}
}
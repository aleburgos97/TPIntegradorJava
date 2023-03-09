package tp;

public class Resultados {
    private String equipo1;
    private String equipo2;
    private String resultado;

    public Resultados(String equipo1, String equipo2, String resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public String getResultado() {
        return resultado;
    }
}

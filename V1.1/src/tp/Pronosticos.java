package tp;

public class Pronosticos {
    private String partido;
    private String resultadoPronostico;
    
    public Pronosticos(String partido, String resultadoPronostico) {
        this.partido = partido;
        this.resultadoPronostico = resultadoPronostico; 
    }
    public String getPartido() {
        return partido;
    }

    public String resultadoPronostico() {
        return resultadoPronostico;
    }
}

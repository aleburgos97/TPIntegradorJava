package tp;

public class Pronosticos {
    private String partido;
    private String resultadoPronostico;
    
    public Pronosticos(String partido, String resultadoPronostico) {
        this.partido = partido;
        this.resultadoPronostico = resultadoPronostico; 
    }
    //Constructor vacio para facilitar inicializacion
    public Pronosticos () {
    	this.partido="";
    	this.resultadoPronostico="";
    }
    public String getPartido() {
        return partido;
    }

    public String resultadoPronostico() {
        return resultadoPronostico;
    }
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public void setResultadoPronostico(String resultadoPronostico) {
		this.resultadoPronostico = resultadoPronostico;
	}
    
}

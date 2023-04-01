package tp;

public class Pronosticos {
    private String partido;
    private String resultadoPronostico;
    private String id;
    
    public Pronosticos(String partido, String resultadoPronostico, String id) {
        this.partido = partido;
        this.resultadoPronostico = resultadoPronostico;
        this.id = id;
    }
    //Constructor vacio para facilitar inicializacion
    public Pronosticos () {
    	this.partido="";
    	this.resultadoPronostico="";
    	this.id="";
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
    
}

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
    //Constructor vacio para facilitar inicializacion
    public Resultados () {
    	this.equipo1="";
    	this.equipo2="";
    	this.resultado="";
    }
	public String getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}
	public String getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
    
    
}
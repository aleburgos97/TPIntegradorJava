package tp;

public class Participantes {
	private String id;
	private String nombre;
	private String partido;
	public Participantes(String id, String nombre, String partido) {
		this.id = id;
		this.nombre = nombre;
		this.partido = partido;
	}
	//constructor vacio
	public Participantes() {
		this.id="";
		this.nombre="";
		this.partido="";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	
	
}

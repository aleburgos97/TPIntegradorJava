package alt;

import java.util.ArrayList;
import java.util.Iterator;

public class Participante {
	private String nombre;
	private ArrayList <String> apuestas;
	private int puntaje;
	
	public Participante (String n) {
		this.nombre=n;
		this.apuestas = new ArrayList<String>();
		this.puntaje=0;
	}
	
	public void agregarApuesta(String a) {
		this.apuestas.add(a);
	}
	public void agregarPunto() {
		this.puntaje++;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getPuntaje() {
		return this.puntaje;
	}
	public Iterator<String> getIterator() {
		return apuestas.iterator();
	}

	public String toString() {
		return "Participante [nombre=" + nombre + ", puntaje=" + puntaje + "]";
	}
	
}



package tp;

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
	public int getCantApuestas() {
		return apuestas.size();
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
	public String getApuesta(int a) {
		return this.apuestas.get(a);
	}

	public String toString() {
		return "Participante [nombre=" + nombre + ", puntaje=" + puntaje + "]";
	}
	
}



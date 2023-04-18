package alt;

import java.util.ArrayList;
import java.util.Iterator;

public class PronosticosDeportivos {
	private Partidos p;
	private ArrayList <Participante> participantes;
	
	public PronosticosDeportivos(String ruta) {
		this.participantes = new ArrayList <Participante>();
		this.p = new Partidos (ruta);
	}
	
	public void agregarParticipante(Participante par, String[]apuestas) {
		for(String s : apuestas) {
			par.agregarApuesta(s);
		}
		this.participantes.add(par);
	}
	
	public void cerrar() {
		Iterator<String> it;
		Iterator<String>itp;
		for (Participante par : participantes) {
			it=par.getIterator();
			itp=p.getIterator();
			while(itp.hasNext()) {
				if(it==itp) {
					par.agregarPunto();
				}
				it.next();
				itp.next();
			}
		}
		System.out.println("Resultados:");
		for(Participante par : participantes) {
			System.out.println(par.toString());
		}
	}
	
}

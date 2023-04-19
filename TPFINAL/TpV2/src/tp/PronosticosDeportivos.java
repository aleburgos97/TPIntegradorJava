package tp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
/* Utilizar nombres de variables mas significativos.
 * 
 * 
 * 
 * */
import java.util.ArrayList;
import java.util.Scanner;

public class PronosticosDeportivos {
	private ArrayList <Partido> partidos ;
	private ArrayList <Participante> participantes;
	
	public PronosticosDeportivos(String ruta) {
		this.participantes = new ArrayList <Participante>();
		this.partidos = new ArrayList <Partido>();
		try {
			File file = new File(ruta);
			Scanner scanner = new Scanner(file);
			ArrayList <String> aux = new ArrayList<String>();
			while (scanner.hasNextLine()) {
			    String linea = scanner.nextLine();
			    aux.add(linea);
			}
			for(int i=0;i<aux.size();i+=4) {
				partidos.add(new Partido(aux.get(i),aux.get(i+1),Integer.parseInt(aux.get(i+2)),Integer.parseInt(aux.get(i+3))));
//				if(i>=aux.length) //Creo que no hace falta, pero por las dudas
//					break;//QuickFix para evitar un IndexOutOfBounds
			}
            scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarParticipante(String nombre, String ruta) {
		Participante par = new Participante(nombre);
		try {
			File file = new File(ruta);
			Scanner scanner = new Scanner(file);
			ArrayList<String> aux = new ArrayList<String>();
			while(scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				aux.add(linea);
			}
			for (String s : aux) {
				par.agregarApuesta(s);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo.");
		}
		this.participantes.add(par);
	}
	
	public void cerrar() {
		int i=0;
		for(Partido p : partidos) {
			System.out.println(p.toString());
			for (Participante man : participantes) {
				
				if(i<man.getCantApuestas() && man.getApuesta(i).equals(p.getResultado())) {
					man.agregarPunto();
					
					// System.out.println(man.getNombre()+" +1 ");
					System.out.println("Puntaje total al momento del participante "+man.getNombre()+" es de: "+man.getPuntaje()+" puntos.");
				}
			}
			i++;
		}
	}
	 public void verResultados() {
	      // Ordenar participantes por puntaje descendente
	      Collections.sort(participantes, new Comparator<Participante>() {
	         @Override
	         public int compare(Participante p1, Participante p2) {
	            return Integer.compare(p2.getPuntaje(), p1.getPuntaje());
	         }
	      });

	      // Mostrar resultados
	      for (int i = 0; i < participantes.size(); i++) {
	         Participante participante = participantes.get(i);
	         System.out.println((i + 1) + ". " + participante.getNombre() + " : " + participante.getPuntaje());
	      }

	      Participante ganador = participantes.get(0);
	      System.out.println("El ganador es " + ganador.getNombre() + " con " + ganador.getPuntaje() + " puntos.");
	   }
	
}

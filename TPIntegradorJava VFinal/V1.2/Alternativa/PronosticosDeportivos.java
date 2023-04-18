package alt;
import java.io.File;
import java.io.FileNotFoundException;
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
					System.out.println(man.getNombre()+" +1");
				}
			}
			i++;
		}
	}
	
}

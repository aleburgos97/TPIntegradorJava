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
		try {
			String [] aux = null;
			File file = new File(ruta);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
			    String linea = scanner.nextLine();
			    aux = linea.split(System.lineSeparator());
			}
			for(int i=0;i<aux.length;i+=4) {
				partidos.add(new Partido(aux[i],aux[i+1],Integer.parseInt(aux[i+2]),Integer.parseInt(aux[i+3])));
				if(i>=aux.length)
					break;//QuickFix para evitar un IndexOutOfBounds
			}
            scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarParticipante(Participante par, String[]apuestas) {
		for(String s : apuestas) {
			par.agregarApuesta(s);
		}
		this.participantes.add(par);
	}
	
	public void cerrar() {
		//Rehacer
	}
	
}

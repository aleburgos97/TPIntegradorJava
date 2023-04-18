package alt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//Resultados de los partidos
public class Partidos {
	private ArrayList <String> resultados;
	private String [] partes;
	public Partidos(String ruta) {
		this.resultados = new ArrayList<String>();
		try {
			File file = new File(ruta);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                partes = linea.split(",");
            }
            scanner.close();
		}
		catch(IOException io){
			System.out.println("Error al cargar partidos. Error: "+io.getMessage());
		}
		for(String p : partes) {
			this.resultados.add(p);
		}
	}
	public Iterator<String> getIterator() {
		return resultados.iterator();
	}
	
}

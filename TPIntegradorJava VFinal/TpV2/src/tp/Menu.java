package tp;
import java.util.Scanner;


public class Menu {
	public static void main (String[]args) {
		Scanner scanner = new Scanner(System.in);
		PronosticosDeportivos pronos = new PronosticosDeportivos ("C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\TPIntegradorJava-Alternativa\\V1.2\\Alternativa\\Partidos");
		
		/*
		pronos.agregarParticipante("Daniel", "C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\TPIntegradorJava-Alternativa\\V1.2\\Alternativa\\ApuestasDaniel");
		pronos.agregarParticipante("Eduardo", "C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\TPIntegradorJava-Alternativa\\V1.2\\Alternativa\\ApuestasEduardo");
		pronos.cerrar();
		*/
		int opcion = 0;
		boolean pronosticosCargados = false;
		while(opcion != 4) {
		    System.out.println("Menú:");
		    System.out.println("1. Agregar participante");
		    System.out.println("2. Cargar pronósticos");
		    System.out.println("3. Ver Resultados");
		    System.out.println("4. Salir");
		    opcion = scanner.nextInt();
		    scanner.nextLine(); // Consumir el salto de línea después de la opción elegida
		    switch(opcion) {
		        case 1:
		            System.out.println("Ingrese el nombre del participante:");
		            String nombre = scanner.nextLine();
		        	System.out.println("                ");
		            System.out.println("Ingrese la ruta del archivo con las apuestas del participante:");
		            String rutaArchivoApuestas = scanner.nextLine();
		        	System.out.println("                ");
		            pronos.agregarParticipante(nombre, rutaArchivoApuestas);
		            break;
		        case 2:
		        	if(pronosticosCargados) {
			        	System.out.println("                ");
			        	System.out.println("                ");
			        	System.out.println("                ");
		        		System.out.println("Los pronosticos ya han sido cargados");
			        	System.out.println("                ");
			        	System.out.println("                ");
			        	System.out.println("                ");
		        	}else {
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	System.out.println("          ...Cargando...         ");
		            pronos.cerrar();
		            pronosticosCargados=true;
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	System.out.println("          Fin de la carga.      ");
		        	
		        	}
		            break;
		        case 3:
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	pronos.verResultados();
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	break;
		        case 4:
		        	System.out.println("                ");
		            System.out.println("¡Hasta luego!");
		        	System.out.println("                ");
		            break;
		        default:
		        	System.out.println("                ");
		            System.out.println("Opción inválida.");
		        	System.out.println("                ");
		            break;
		    }
		}
	}
}


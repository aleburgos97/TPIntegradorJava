package tp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Menu {
	public static void main (String[]args) {
		Scanner scanner = new Scanner(System.in);
		conectarMySql conexion = new conectarMySql();
		PronosticosDeportivos pronos = new PronosticosDeportivos ("C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\TPIntegradorJava VFinal\\V1.2\\Alternativa\\Partidos");
		
		/*
		pronos.agregarParticipante("Daniel", "C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\TPIntegradorJava VFinal\\V1.2\\Alternativa\\ApuestasDaniel");
		pronos.agregarParticipante("Eduardo", "C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\TPIntegradorJava VFinal\\V1.2\\Alternativa\\ApuestasEduardo");
		pronos.cerrar();
		*/
		
		int opcion = 0;
		boolean pronosticosCargados = false;
		while(opcion != 4) {
		    System.out.println("Menú:");
		    System.out.println("1. Agregar participante");
		    System.out.println("2. Cargar pronósticos");
		    System.out.println("3. Ver Resultados");
		    System.out.println("4. Ver tabla mySQL");
		    System.out.println("5. Salir");
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
		        	System.out.println("           Carga Exitosa      ");
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	System.out.println("                ");
		        	
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
		    		Connection cn = null;
		    		Statement stm = null;
		    		ResultSet rs = null;
		    		
		    		try {
		    			cn = conexion.conectar();
		    			stm = cn.createStatement();
		    			rs = stm.executeQuery("SELECT * FROM participante");
		    			while(rs.next()) {
		    				
		    				int idParticipante = rs.getInt(1);
		    				String participante = rs.getString(2);
		    				String apuestas = rs.getString(3);
		    				int puntaje = rs.getInt(4);
		    				System.out.println(idParticipante+"  -  "+participante+"  -  "+apuestas+"  -  puntaje total: "+puntaje);
		    			}
		    		} catch (SQLException e) {
		    		}
		        	System.out.println("                ");
		            System.out.println("                ");
		        	System.out.println("                ");
		            break;
		        case 5:
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


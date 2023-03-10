package tp;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String rutaArchivo = "/home/bigmati/Documentos/GitHub/tpintegrador/Resultados.txt";
        String rutaPronosticos = "/home/bigmati/Documentos/GitHub/tpintegrador/Pronosticos.txt";
        String equipo1 = "";
        String equipo2 = "";
        String resultado = "";
        String resulPronostico="";
        int puntaje = 0;
        String partido="";
        String linea = "";
        String []partes=null;
        String pronostico;
        String []partes2=null;
        // Leer el contenido del archivo y extraer el resultado del partido
        try {
            File file = new File(rutaArchivo);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                partes = linea.split(",");
//                equipo1 = partes[0];
//                equipo2 = partes[1];
//                resultado = partes[2];
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        try {
            File file = new File(rutaPronosticos);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                pronostico = scanner.nextLine();
                partes2 = pronostico.split(",");
//                partido = partes2[0];
//                resulPronostico = partes2[1];
//                if (resulPronostico.equals(resultado))
//                    puntaje++;
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pronósticos.");
            e.printStackTrace();
        }
        //Comparación de resultados/pronosticos
        //Formato partes= equipo1,equipo2,resultado
        //Formato partes2= numeroPartido, resultado
        for (int i=0;i<partes.length;i+=3) {
        	equipo1 = partes[i];
            equipo2 = partes[i+1];
            resultado = partes[i+2];
        	for (int j=0;j<partes2.length;j+=2) {
        		partido = partes2[j];
                resulPronostico = partes2[j+1];
                if (resulPronostico.equals(resultado))
                    puntaje++;
        	}
        }
        // Imprimir el resultado del partido
        System.out.println("El resultado del partido nro "+ partido+" entre " + equipo1 + " y " + equipo2 + " fue " + resultado);
        // Imprimir el puntaje del usuario
        System.out.println("El puntaje del usuario es " + puntaje+" ya que su apuesta habia sido "+resulPronostico);
    }


    }


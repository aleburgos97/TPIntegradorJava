package tp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\V1\\Resultados.txt";
        String rutaPronosticos = "C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\V1\\Pronosticos.txt";
        String equipo1 = "";
        String equipo2 = "";
        String resultado = "";
        String resulPronostico="";
        int puntaje = 0;
        String partido="";

        // Leer el contenido del archivo y extraer el resultado del partido
        try {
            File file = new File(rutaArchivo);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                equipo1 = partes[0];
                equipo2 = partes[1];
                resultado = partes[2];
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
                String pronostico = scanner.nextLine();
                String[] partes2 = pronostico.split(",");
                partido = partes2[0];
                resulPronostico = partes2[1];
                if (resulPronostico.equals(resultado)) {
                    puntaje++;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pronósticos.");
            e.printStackTrace();
        }
        // Imprimir el resultado del partido
        System.out.println("El resultado del partido nro "+ partido+" entre " + equipo1 + " y " + equipo2 + " fue " + resultado);
        // Imprimir el puntaje del usuario
        System.out.println("El puntaje del usuario es " + puntaje+" ya que su apuesta habia sido "+resulPronostico);
    }


    }


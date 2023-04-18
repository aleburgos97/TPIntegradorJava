package tp;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\windows 10\\Desktop\\TPIntegradorJava-master\\V1.1\\Resultados.txt";
        String rutaPronosticos = "C:\\Users\\windows 10\\Desktop\\TPIntegradorJava-master\\V1.1\\Pronosticos.txt";
        String rutaParticipantes = "C:\\Users\\Ale\\Desktop\\TPIntegradoJava\\V1.1\\Participantes.txt";
        int numResultados = contarResultados(rutaArchivo);
        int numPronosticos = contarPronosticos(rutaPronosticos);
        //int numParticipantes = contarParticipantes(rutaParticipantes);

        Resultados [] res = new Resultados[numResultados];
        Pronosticos [] pro = new Pronosticos[numPronosticos];
        Participantes [] par = new Participantes[15];

        String equipo1 = "";
        String equipo2 = "";
        String resultado = "";
        String resulPronostico="";
        int puntaje = 0,numLineas=0,numLineas2=0,numLineas3=0;
        String partido="";
        String linea = "";
        String []partes=null;
        String pronostico;
        String []partes2=null;
        String []partes3=null;
        // Leer el contenido del archivo y extraer el resultado del partido
        try {
            File file = new File(rutaArchivo);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                numLineas++;
                partes = linea.split(",");
//                equipo1 = partes[0];
//                equipo2 = partes[1];
//                resultado = partes[2];
            }
            scanner.close();

            //Resultados[] res = new Resultados[numLineas];
            //Carga de resultados al vector res
            int j=0;
            for (int i=0;i<partes.length/3;i++) {
        		res[i]= new Resultados (partes[j],partes[j+1],partes[j+2]);
        		j+=3;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        try {
            File file = new File(rutaPronosticos);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                pronostico = scanner.nextLine();
                numLineas2++;
                partes2 = pronostico.split(",");
//                partido = partes2[0];
//                resulPronostico = partes2[1];
//                if (resulPronostico.equals(resultado))
//                    puntaje++;
                
            }
            scanner.close();

            //Carga de partidos al vector de Pronosticos
            int j=0;
            for (int i=0;i<partes2.length/3;i++) {
        		pro[i]=new Pronosticos(partes2[j],partes2[j+1],partes2[j+2]);
        		j+=3;
//            	pro[i].setPartido(partes2[i]);
//            	pro[i+1].setResultadoPronostico(partes2[i+1]);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pronósticos.");
            e.printStackTrace();
        }
        try {
            File file = new File(rutaParticipantes);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                numLineas3++;
                partes3 = linea.split(",");

            }
            scanner.close();

            //Participantes[] par = new Participantes[numParticipantes];
            //Carga de participantes al vector par
            int j=0;
            for (int i=0;i<partes.length/3;i++) {
        		par[i]= new Participantes (partes3[j],partes3[j+1],partes3[j+2]);
        		j+=3;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }

        
        //Comparación de resultados/pronosticos/participantes
        //Formato partes= equipo1,equipo2,resultado
        //Formato partes2= numeroPartido, resultado, idParticipante
        //Formate partes3= idParticipante, Nombre, numPartido
        for (int i=0;i<pro.length;i++) {
    		if(pro[i]!=null) {
	        	if(pro[i].resultadoPronostico().equals(res[i].getResultado()))
				puntaje++;
	    		System.out.println("El resultado del partido nro "+pro[i].getPartido()+" entre " + res[i].getEquipo1() + " y " + res[i].getEquipo2() + " fue " + res[i].getResultado());
	    		System.out.println("El puntaje del usuario es " +puntaje+" ya que su apuesta habia sido "+pro[i].resultadoPronostico());
    		}
//        	equipo1 = partes[i];
//          equipo2 = partes[i+1];
//          resultado = partes[i+2];
//        	for (int j=0;j<partes2.length;j++) {
//        		
////        		partido = partes2[j];
////              resulPronostico = partes2[j+1];
////              if (resulPronostico.equals(resultado))
////                  puntaje++;
//        		if(pro[i].resultadoPronostico().equals(res[j].getResultado()))
//        			puntaje++;
//        	}
        }
        // Imprimir el resultado del partido
//        System.out.println("El resultado del partido nro "+partido+" entre " + equipo1 + " y " + equipo2 + " fue " + resultado);
        // Imprimir el puntaje del usuario
//        System.out.println("El puntaje del usuario es " + puntaje+" ya que su apuesta habia sido "+resulPronostico);
    }
    private static int contarResultados(String rutaArchivo) {
        int numResultados = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                numResultados += partes.length / 3; // Cada resultado tiene tres partes: equipo1, equipo2, resultado
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numResultados;
    }
    private static int contarPronosticos(String rutaPronosticos) {
        int numPronosticos = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaPronosticos))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes2 = line.split(",");
                numPronosticos += partes2.length / 2; // Cada resultado tiene tres partes: equipo1, equipo2, resultado
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numPronosticos;
    }

    }


package tp;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String rutaArchivo = "/home/bigmati/Documentos/GitHub/tpintegrador/Resultados.txt";
        String rutaPronosticos = "/home/bigmati/Documentos/GitHub/tpintegrador/Pronosticos.txt";
        Pronosticos [] pro = new Pronosticos[15];
        Resultados [] res = new Resultados[15];
        
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
                partes2 = pronostico.split(",");
//                partido = partes2[0];
//                resulPronostico = partes2[1];
//                if (resulPronostico.equals(resultado))
//                    puntaje++;
                
            }
            scanner.close();
            //Carga de partidos al vector de Pronosticos
            int j=0;
            for (int i=0;i<partes2.length/2;i++) {
        		pro[i]=new Pronosticos(partes2[j],partes2[j+1]);
        		j+=2;
//            	pro[i].setPartido(partes2[i]);
//            	pro[i+1].setResultadoPronostico(partes2[i+1]);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pronósticos.");
            e.printStackTrace();
        }
        
        //Comparación de resultados/pronosticos
        //Formato partes= equipo1,equipo2,resultado
        //Formato partes2= numeroPartido, resultado
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


    }


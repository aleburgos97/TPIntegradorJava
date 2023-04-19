package Enunciado;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ejemploBDFile {

	public static void main(String[] args) {
		try{  
			Class.forName("org.postgresql.Driver");  
		//	Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.0.102:5433/APC128","postgres","inside");  
		//	Connection con=DriverManager.getConnection(“jdbc:mysql://localhost:3306/dbname","root","password”);
			Statement stmt=con.createStatement();  
			//USO DE LA DB  
			System.out.println("conecto");  
			//creo la tabla
			int result=stmt.executeUpdate("CREATE TABLE equipo (id INT, nombre VARCHAR)");
			System.out.println(result + " records affected");
			//itero el archivo y grabo en la base de datos
			for (String linea: Files.readAllLines(Paths.get("src\\main\\java\\Archivo\\equipos.txt"))){
				String id =linea.split(";")[0];
				String nombre = linea.split(";")[1];
				String sentencia="insert into equipo (id,nombre) values ("+id+",\'"+nombre+"\')";
				System.out.println(sentencia);
				int resulte=stmt.executeUpdate(sentencia);
				System.out.println(resulte + " records affected");  
			}
			
			con.close();  
			} catch(Exception e){ System.out.println(e);}  

	}
}

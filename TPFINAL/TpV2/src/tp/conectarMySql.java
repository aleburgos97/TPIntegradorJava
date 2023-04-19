package tp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conectarMySql {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bd_tpjavainicial";
	private static final String USER ="root";
	private static final String PASS ="4294";
	public Connection conectar(){
		Connection conexion = null;
	 	try {
			Class.forName(CONTROLADOR);
			
			conexion = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Conexion exitosa");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("Error en la conexion");
		}
	 	return conexion;
	}


}

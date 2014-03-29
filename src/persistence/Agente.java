package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.exceptions.NoAvailableConnections;

public class Agente {

	private static Agente instancia = null;
	private static Connection conexiones[];
	private static boolean disponibles[];
	private static final int nconexiones = 50;
	
	// Datos de conexion con la BD
	private static final String	user = "root",
								password = "9648",
								url = "jdbc:mysql://localhost/tienda_online";
	
	//Constructor del singleton.
	private Agente() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		conexiones = new Connection[nconexiones];
		disponibles = new boolean[nconexiones];
		
		Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		for (int i = 0; i < nconexiones; i++) {
			disponibles[i] = true;
			conexiones[i] = DriverManager.getConnection (url, user, password);
		}
	}
	
	//Obtener instancia del singleton.
	public synchronized static Agente getInstancia() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		if (instancia == null) {
			instancia = new Agente();
		}
		return instancia;
	}
	
	public ResultSet select(String SQL, Connection c) throws SQLException {
		return c.createStatement().executeQuery(SQL);	
	}
	
	public int insert(String SQL, Connection c) throws SQLException {
		return c.createStatement().executeUpdate(SQL);	
	}
	
	public int delete(String SQL, Connection c) throws SQLException {
		return c.createStatement().executeUpdate(SQL);	
	}
	
	public int update(String SQL, Connection c) throws SQLException {
		return c.createStatement().executeUpdate(SQL);	
	}
	
	public synchronized Connection getConnection() throws NoAvailableConnections{
		Connection conexion = null;
		for (int i = 0; i < nconexiones; i++) {
			if (disponibles[i]) {
				conexion = conexiones[i];
				disponibles[i] = false;
				break;
			}
		}
		if (conexion == null) {
			throw new NoAvailableConnections();
		}
		return conexion;
	}
	
	public synchronized void release(Connection conexion) {
		for (int i = 0; i < nconexiones; i++) {
			if (conexiones[i].equals(conexion)) {				
				disponibles[i] = true;
				break;
			}
		}
	}
	
	public void closeAll() throws SQLException {
		for (int i = 0; i < nconexiones; i++) {
			if (conexiones[i] != null) {
				conexiones[i].close();
			}
			disponibles[i] = true;
		}
	}
}

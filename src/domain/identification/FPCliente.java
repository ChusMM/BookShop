package domain.identification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistence.Agente;
import domain.exceptions.InvalidUserException;
import domain.exceptions.NoAvailableConnections;
import domain.exceptions.ClienteExistente;

public class FPCliente {
	
	public static Cliente Log(String login) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidUserException{
		Cliente result = null;
		
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "Select * from usuarios " +
				"where login ='"+ login + "'";
		
		ResultSet r = Agente.getInstancia().select(SQL, conn);
		Agente.getInstancia().release(conn);
		
		if(r.first()) {
			result = new Cliente(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getBoolean(9), r.getString(10), r.getString(11), r.getString(12));
		}
		else {
			//throw new InvalidUserException(login);
		}
		
		return result;
	}
	
	public static Cliente Log(String login, String pass) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidUserException{
		Cliente result = null;
		
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "Select * from usuarios " +
				"where login ='"+ login + "'and password='" + pass + "'";
		
		ResultSet r = Agente.getInstancia().select(SQL, conn);
		Agente.getInstancia().release(conn);
		
		if(r.first()) {
			result = new Cliente(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getBoolean(9), r.getString(10), r.getString(11), r.getString(12));
		}
		else {
			throw new InvalidUserException(login);
		}
		
		return result;
	}
	
	public static Cliente select(String nombre) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidUserException {
		Cliente result = null;
		
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "Select * from usuarios " +
				"where login ='"+ nombre + "'";
		
		ResultSet r = Agente.getInstancia().select(SQL, conn);
		Agente.getInstancia().release(conn);
		
		if(r.first()) {
			result = new Cliente(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getBoolean(9), r.getString(10), r.getString(11), r.getString(12));
		}else {
			throw new InvalidUserException(nombre);
		}
		return result;
	}
	
	public static void insert(Cliente cli) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ClienteExistente, InvalidUserException {
		Connection conn = Agente.getInstancia().getConnection();
		
		String SQL = "Insert into usuarios (Login, Password, Nombre, Ap1, Ap2, Direccion, Telefono, Correo, Admin, CP, Pais, Nacimiento)" +
				     "values ('" + cli.getLogin() + "','" + cli.getPass() + "','" + cli.getNombre()  + "','" + cli.getAp1() + "','" + cli.getAp2() + "','" + cli.getDireccion() + "','" + cli.getTelefono() + "','" + cli.getCorreo() + "'," + cli.isAdmin() + ",'" + cli.getCp() + "','" + cli.getPais() + "','" + cli.getFecha() + "')";
		if(Log(cli.getLogin()) == null) {
			Agente.getInstancia().insert(SQL, conn);
		}
		else {
			throw new ClienteExistente(cli.getLogin());
		}
	}
	
	public static void delete(String nombre) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidUserException {
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "delete from usuarios " +
					 "where login ='"+ nombre + "'";
		if(select(nombre) !=  null) {
			Agente.getInstancia().delete(SQL, conn);
		}
	}
	
	public static void update(Cliente cli) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidUserException {
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "update usuarios set login = '"+ cli.getLogin() + "', password = '" + cli.getPass() + "', nombre = '" + cli.getNombre()  + "', ap1 = '" + cli.getAp1() + "', ap2 = '" + cli.getAp2() + "', direccion = '" + cli.getDireccion() + "', telefono = '" + cli.getTelefono() + "', correo = '" + cli.getCorreo() + "', admin = " + cli.isAdmin() + ", cp = '" + cli.getCp() + "', pais = '" + cli.getPais() + "', nacimiento = '" + cli.getFecha() + "' where login = '"+ cli.getLogin() + "'";
		if(Log(cli.getLogin()) != null) {
			Agente.getInstancia().update(SQL, conn);
		}
	}
}

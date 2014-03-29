package domain.identification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistence.Agente;
import domain.exceptions.NoAvailableConnections;
import domain.exceptions.InvalidProductException;
import domain.exceptions.ProductoExistente;

public class FPArticulo {

	public static void insert(Articulo a) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ProductoExistente{
		Connection conn = Agente.getInstancia().getConnection();
		
		String SQL = "Insert into productos (ID, Nombre, Autor, Fecha, Ejemplares, Foto, Precio, Descripcion, Categoria, Tipo) " +
				     "values ('" + a.getId() + "','" + a.getNombre() + "','" + a.getAutor() + "','" + a.getFecha()  + "'," + a.getEjemplares() + ",'" + a.getFoto() + "'," + a.getPrecio() + ",'" + a.getDescripcion() + "','" + a.getCategoria() + "','" + a.getTipo() + "')";
		try{
			select(a.getId());
			throw new ProductoExistente(a.getId());
		}catch(InvalidProductException e){
			Agente.getInstancia().insert(SQL, conn);
		}
	}
	
	public static Articulo select(String id) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		Articulo result = null;
		
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "Select * from productos " +
				"where id ='"+ id + "'";
		
		ResultSet r = Agente.getInstancia().select(SQL, conn);
		Agente.getInstancia().release(conn);
		
		if(r.first()) {
			result = new Articulo(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getString(6), r.getFloat(7), r.getString(8), r.getString(9), r.getString(10).charAt(0));
		}else {
			throw new InvalidProductException(id);
		}
		return result;
	}
	
	public static ArrayList<domain.identification.Articulo> selectLibros() throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		ArrayList<domain.identification.Articulo> result = new ArrayList<domain.identification.Articulo>();
		
		
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "Select * from productos " +
				"where Tipo ='L'";
		
		ResultSet r = Agente.getInstancia().select(SQL, conn);
		Agente.getInstancia().release(conn);
		
		while (r.next()) {
			result.add(new Articulo(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getString(6), r.getFloat(7), r.getString(8), r.getString(9), r.getString(10).charAt(0)));
        }
		
		return result;
	}
	
	public static ArrayList<domain.identification.Articulo> selectDiscos() throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		ArrayList<domain.identification.Articulo> result = new ArrayList<domain.identification.Articulo>();
		
		
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "Select * from productos " +
				"where Tipo ='D'";
		
		ResultSet r = Agente.getInstancia().select(SQL, conn);
		Agente.getInstancia().release(conn);
		
		while (r.next()) {
			result.add(new Articulo(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getString(6), r.getFloat(7), r.getString(8), r.getString(9), r.getString(10).charAt(0)));
        }
		
		return result;
	}
	
	public static void delete(String id) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "delete from productos " +
					 "where id ='"+ id + "'";
		if(select(id) !=  null) {
			Agente.getInstancia().delete(SQL, conn);
		}
	}
	
	public static void update(Articulo a) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "update productos set id = '"+ a.getId() + "', nombre = '" + a.getNombre() + "', autor = '" + a.getAutor()  + "', fecha = '" + a.getFecha() + "', ejemplares = " + a.getEjemplares() + ", foto = '" + a.getFoto() + "', precio = " + a.getPrecio() + ", descripcion = '" + a.getDescripcion() + "', categoria = '" + a.getCategoria() + "', tipo = '" + a.getTipo() + "' where id = '" + a.getId() + "';";
		if(select(a.getId()) != null) {
			Agente.getInstancia().update(SQL, conn);
		}
	}
	
	public static void update(String id, int cantidad) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		Connection conn = Agente.getInstancia().getConnection();
		String SQL = "update productos set ejemplares = ejemplares - " + cantidad + " where id = '" + id + "';";
		if(select(id) != null) {
			Agente.getInstancia().update(SQL, conn);
		}
	}
}

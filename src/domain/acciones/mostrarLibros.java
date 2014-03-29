package domain.acciones;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.exceptions.*;
import domain.identification.*;

public class mostrarLibros {
	
	private ArrayList<domain.identification.Articulo> libros = new ArrayList<domain.identification.Articulo>();
	
	public String execute(){
		try {
			libros = Articulo.selectLibros();
			return "Success";
		}
		catch (InvalidProductException e) {
			return "UsuarioNoValido";
		}catch (NoAvailableConnections e){
			return "NoHayConexionesLibres";
		}catch(ClassNotFoundException e){
			return "ClaseNoEncontrada";
		}catch(InstantiationException e){
			return "InstantiationException";
		}catch(IllegalAccessException e){
			return "AccesoIlegal";
		}catch(SQLException e){
			return "ExcepcionSQL";
		}
	}

	public void setLibros(ArrayList<domain.identification.Articulo> newLibros) {
		libros = newLibros;
	}
	
	public ArrayList<domain.identification.Articulo> getLibros(){
		return libros;
	}
	

}

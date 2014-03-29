package domain.acciones;

import java.sql.SQLException;

import domain.identification.*;
import domain.exceptions.*;

public class addProducto {

	private String id;
	private String nombre;
	private String autor;
	private String fecha;
	private int ejemplares;
	private String foto;
	private float precio;
	private String descripcion;
	private String categoria;
	private char tipo;
	private Articulo a;
	
	public String execute(){
		
		try{
			a = new Articulo(id, nombre, autor, fecha, ejemplares, foto, precio, descripcion, categoria, tipo);
			a.insert();
			return "Success";
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
		}catch(ProductoExistente e){
			return "ProductoExistente";
		}
	}
	
	
	public void setId(String newId){
		id = newId;
	}
	public void setNombre(String newNombre){
		nombre = newNombre;
	}
	public void setAutor(String newAutor){
		autor = newAutor;
	}
	public void setFecha(String newFecha){
		fecha = newFecha;
	}
	public void setEjemplares(int newEjemplares){
		ejemplares = newEjemplares;
	}
	public void setFoto(String newFoto){
		foto = newFoto;
	}
	public void setPrecio(float newPrecio){
		precio = newPrecio;
	}
	public void setDescripcion(String newDescripcion){
		descripcion = newDescripcion;
	}
	public void setCategoria(String newCategoria){
		categoria = newCategoria;
	}
	public void setTipo(char newTipo){
		tipo = newTipo;
	}
	
}

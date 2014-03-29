package domain.identification;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.exceptions.InvalidProductException;
import domain.exceptions.ProductoExistente;
import domain.exceptions.NoAvailableConnections;

public class Articulo {
	
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
	
	public Articulo(String id, String nombre, String autor, String fecha, int ejemplares, String foto, float precio, String descripcion, String categoria, char tipo){
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.fecha = fecha;
		this.ejemplares = ejemplares;
		this.foto = foto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.tipo = tipo;
	}
	
	public Articulo(){
		
	}
	
	public void insert() throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ProductoExistente {
		FPArticulo.insert(this);
	}
	
	public static Articulo select(String id) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		return FPArticulo.select(id);
	}
	
	public static ArrayList<domain.identification.Articulo> selectLibros() throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		return FPArticulo.selectLibros();
	}
	
	public static ArrayList<domain.identification.Articulo> selectDiscos() throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		return FPArticulo.selectDiscos();
	}
	
	public static void delete(String id) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		FPArticulo.delete(id);
	}
	
	public static void update(Articulo a) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		FPArticulo.update(a);
	}
	
	public static void update(String id, int cantidad) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidProductException {
		FPArticulo.update(id, cantidad);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

}

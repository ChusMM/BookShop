package domain.identification;

import java.sql.SQLException;

import domain.exceptions.ClienteExistente;
import domain.exceptions.InvalidUserException;
import domain.exceptions.NoAvailableConnections;

public class Cliente {
	private String login;
	private String password;
	private String nombre;
	private String ap1;
	private String ap2;
	private String direccion;
	private String telefono;
	private String correo;
	private boolean admin;
	private String cp;
	private String pais;
	private String fecha;

	public Cliente(String login, String password, String nombre, String ap1, String ap2, String direccion, String telefono, String correo, boolean admin, String cp, String pais, String fecha) {
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.ap1 = ap1;
		this.ap2 = ap2;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.admin = admin;
		this.cp = cp;
		this.pais = pais;
		this.fecha = fecha;
	}

	public static Cliente identify(String login) throws InvalidUserException, NoAvailableConnections, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return FPCliente.Log(login);
	}
	
	public static Cliente identify(String login, String pass) throws InvalidUserException, NoAvailableConnections, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		return FPCliente.Log(login, pass);
	}
	
	public void insert() throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ClienteExistente, InvalidUserException {
		FPCliente.insert(this);
	}
	
	public static void delete(String log) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidUserException {
		FPCliente.delete(log);
	}
	
	public static void update(Cliente cli) throws NoAvailableConnections, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, InvalidUserException {
		FPCliente.update(cli);
	}

	public String getLogin() {
		return this.login;
	}
	
	public String getPass() {
		return this.password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp1() {
		return ap1;
	}

	public void setAp1(String ap1) {
		this.ap1 = ap1;
	}

	public String getAp2() {
		return ap2;
	}

	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}

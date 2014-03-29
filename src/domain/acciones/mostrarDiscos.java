package domain.acciones;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.exceptions.InvalidProductException;
import domain.exceptions.NoAvailableConnections;
import domain.identification.Articulo;

public class mostrarDiscos {
	
private ArrayList<domain.identification.Articulo> discos = new ArrayList<domain.identification.Articulo>();
	
	public String execute(){
		try {
			discos = Articulo.selectDiscos();
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

	public void setDiscos(ArrayList<domain.identification.Articulo> newDiscos) {
		discos = newDiscos;
	}
	public ArrayList<domain.identification.Articulo> getDiscos(){
		return discos;
	}

}

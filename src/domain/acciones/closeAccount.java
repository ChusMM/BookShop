package domain.acciones;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionContext;
import domain.identification.*;
import domain.exceptions.*;

public class closeAccount {

	Cliente c;
	
	public String execute(){
			
			try {
				c = (Cliente)ActionContext.getContext().getSession().get("cliente");
				Cliente.delete(c.getLogin());
				return "Success";
			}
			catch (InvalidUserException e) {
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
	
}

package domain.acciones;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;

import domain.identification.*;
import domain.exceptions.*;

public class identify implements ServletRequestAware, ServletResponseAware{
	
	private String login;
	private String password;
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	public String execute(){
		
		try {
			request.getSession(true);
			Cliente c = Cliente.identify(login, password);
			ActionContext.getContext().getSession().put("cliente", c);
			Carrito car = new Carrito();
			ActionContext.getContext().getSession().put("carrito", car);
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
	
	public void setLogin(String newLogin){
		login = newLogin;
	}
	public void setPassword(String newPassword){
		password = newPassword;
	}

	@Override
	public void setServletResponse(HttpServletResponse res) {
		response = res;		
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		request = req;		
	}

}

package domain.acciones;

import java.sql.SQLException;

import paypal.domain.Pago;
import paypal.excepciones.ImporteInvalidoException;
import paypal.excepciones.MesInvalidoException;
import paypal.excepciones.NoHayConexionesLibresException;
import paypal.excepciones.PagoRechazadoException;
import paypal.excepciones.TarjetaCaducadaException;
import paypal.excepciones.UsuarioIncorrectoException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.exceptions.InvalidProductException;
import domain.exceptions.NoAvailableConnections;
import domain.identification.Articulo;
import domain.identification.Carrito;

public class PagarConPayPal extends ActionSupport {
	private String correoUsuario;
	private String pwd;
	private double precioTotal;
	private String alumno;
	private Carrito c;
	
	public String execute() {
		try {
			c = (Carrito)ActionContext.getContext().getSession().get("carrito");
			for (int i=0; i < c.getNumero_Productos(); i++){
				c.quitarProducto(c.getLista()[i]);
				Articulo.update(c.getLista()[i].getId(), c.getCantidad()[i]);
			}
			c = new Carrito();
			ActionContext.getContext().getSession().put("carrito", c);
			Pago.getPago().pagar(correoUsuario, pwd, precioTotal, alumno);
			return SUCCESS;
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		} catch (ImporteInvalidoException e) {
			return "ImporteInvalidoException";
		} catch (UsuarioIncorrectoException e) {
			return "UsuarioIncorrectoException";
		} catch (NoAvailableConnections e) {
			return "NoAvailableConnections";
		} catch (ClassNotFoundException e) {
			return "ClassNotFoundException";
		} catch (InstantiationException e) {
			return "InstantiationException";
		} catch (IllegalAccessException e) {
			return "IllegalAccessException";
		} catch (InvalidProductException e) {
			return "InvalidProductException";
		}
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}


}

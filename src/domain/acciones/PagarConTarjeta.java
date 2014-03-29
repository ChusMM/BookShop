package domain.acciones;

import java.sql.SQLException;

import paypal.domain.Pago;
import paypal.excepciones.ImporteInvalidoException;
import paypal.excepciones.MesInvalidoException;
import paypal.excepciones.NoHayConexionesLibresException;
import paypal.excepciones.PagoRechazadoException;
import paypal.excepciones.TarjetaCaducadaException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.exceptions.InvalidProductException;
import domain.exceptions.NoAvailableConnections;
import domain.identification.Articulo;
import domain.identification.Carrito;

public class PagarConTarjeta extends ActionSupport {
	private String numeroDeTarjeta;
	private int mesCaducidad, anioCaducidad;
	private String titular;
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
			Pago.getPago().pagar(numeroDeTarjeta, mesCaducidad, anioCaducidad, titular, precioTotal, alumno);
			return SUCCESS;
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		} catch (TarjetaCaducadaException e) {
			return "TarjetaCaducadaException";
		} catch (MesInvalidoException e) {
			return "MesInvalidoException";
		} catch (PagoRechazadoException e) {
			return "PagoRechazadoException";
		} catch (ImporteInvalidoException e) {
			return "ImporteInvalidoException";
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

	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	public void setMesCaducidad(int mesCaducidad) {
		this.mesCaducidad = mesCaducidad;
	}

	public void setAnioCaducidad(int anioCaducidad) {
		this.anioCaducidad = anioCaducidad;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	
}

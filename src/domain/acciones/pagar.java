package domain.acciones;

import com.opensymphony.xwork2.ActionContext;

import domain.identification.Carrito;

public class pagar {

	double precioTotal;
	Carrito c;
	
	public String execute(){
		c = (Carrito)ActionContext.getContext().getSession().get("carrito");
		precioTotal = c.getPrecioTotal();
		if (c.getNumero_Productos() > 0)
			return "Success";
		else
			return "NoHayProductos";
	}
	
	public void setPrecioTotal(double newPrecioTotal){
		precioTotal = newPrecioTotal;
	}
	public double getPrecioTotal(){
		return precioTotal;
	}
	
	
}

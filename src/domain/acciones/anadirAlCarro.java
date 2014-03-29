package domain.acciones;

import com.opensymphony.xwork2.ActionContext;

import domain.identification.Articulo;
import domain.identification.Carrito;

public class anadirAlCarro {

	String id;
	int cant;
	Carrito c;
	Articulo a;
	
	public String execute(){
		
		try{
			c = (Carrito)ActionContext.getContext().getSession().get("carrito");
			a = Articulo.select(id);
			c.anadirProducto(a, cant);
			ActionContext.getContext().getSession().put("carrito", c);
			if(a.getTipo() == 'L')
				return "SuccessLibro";
			else
				return "SuccessDisco";
			
		}catch(Exception e){
			return "Error";
		}
		
	}
	
	public void setId(String newId){
		id = newId;
	}
	public void setCant(int newCant){
		cant = newCant;
	}
	
}

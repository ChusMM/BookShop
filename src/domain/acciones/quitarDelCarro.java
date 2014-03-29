package domain.acciones;

import com.opensymphony.xwork2.ActionContext;

import domain.identification.Articulo;
import domain.identification.Carrito;

public class quitarDelCarro {

	String id;
	Carrito c;
	
	public String execute(){
		
		try{
			c = (Carrito)ActionContext.getContext().getSession().get("carrito");
			c.quitarProducto(Articulo.select(id));
			ActionContext.getContext().getSession().put("carrito", c);
			return "Success";
			
		}catch(Exception e){
			return "Error";
		}
		
	}
	
	public void setId(String newId){
		id = newId;
	}
	
}

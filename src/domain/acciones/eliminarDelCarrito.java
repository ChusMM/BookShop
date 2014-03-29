package domain.acciones;

import com.opensymphony.xwork2.ActionContext;

import domain.identification.Articulo;
import domain.identification.Carrito;

public class eliminarDelCarrito {
	
	private String id;
	private Carrito carro;
	
	public String execute(){
		
		try{
			carro = (Carrito)ActionContext.getContext().getSession().get("carrito");
			carro.quitarProducto(Articulo.select(id));
			return "Success";
		}catch(Exception e){
			return "Error";
		}
	}
	
	public void setId(String newId){
		id = newId;
	}

}

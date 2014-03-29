package domain.acciones;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionContext;
import domain.identification.Carrito;
import domain.identification.Articulo;

public class mostrarCarrito {
	private ArrayList<domain.identification.Articulo> articulos = new ArrayList<domain.identification.Articulo>();
	private ArrayList<Integer> cantidades = new ArrayList<Integer>();
	private double precioTotal;
	
	public String execute() {
		try {
			Carrito c = (Carrito)ActionContext.getContext().getSession().get("carrito");
			Articulo []lista = c.getLista();
			precioTotal = c.getPrecioTotal();
			int []l_cantidades = c.getCantidad();
			for(int i = 0; i < c.getNumero_Productos(); i++) {
				articulos.add(lista[i]);
				cantidades.add(l_cantidades[i]);
			}
			return "Success";
		}catch(Exception e) {
			return "Error";
		}
	}
	
	public void setLista(ArrayList<domain.identification.Articulo> articulos) {
		this.articulos = articulos;
	}
	
	public ArrayList<domain.identification.Articulo> getArticulos(){
		return this.articulos;
	}
	
	public void setCantidades(ArrayList<Integer> cantidades) {
		this.cantidades = cantidades;
	}
	
	public ArrayList<Integer> getCantidades(){
		return this.cantidades;
	}
	
	public void setPrecioTotal(double newPrecioTotal){
		precioTotal = newPrecioTotal;
	}
	
	public double getPrecioTotal(){
		return precioTotal;
	}
}

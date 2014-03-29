package domain.identification;

public class Carrito {

	Articulo [] lista = new Articulo[50];
	int [] cantidad = new int[50];
	double precioTotal;
	int numero_productos;
	
	public Carrito(){
		precioTotal = 0.0;
		numero_productos = 0;
	}
	
	public String anadirProducto(Articulo a, int cant){
		boolean repetido = false;
		if (cant > 0){
			for(int i = 0; i <numero_productos && !repetido;i++){
				if (a.getId().compareTo(lista[i].getId()) == 0){
					cantidad[i] += cant;
					precioTotal = precioTotal + a.getPrecio() * cant;
					repetido = true;
				}
			}
			if (!repetido){
				lista[numero_productos] = a;
				cantidad[numero_productos] = cant;
				precioTotal += a.getPrecio() * cant;
				numero_productos++;
			}
			return "Success";
		}else{
			return "Cantidad erronea";
		}
	}
	
	public String quitarProducto(Articulo a){
		boolean encontrado = false;
		for(int i = 0; i < numero_productos; i++){
			if(a.getId().compareTo(lista[i].getId()) == 0){
				encontrado = true;
				precioTotal = precioTotal - lista[i].getPrecio() * cantidad[i];
			}
			if (encontrado && i != numero_productos - 1){
				lista[i] = lista[i+1];
				cantidad[i] = cantidad[i+1];
			}
		}
		if (encontrado){
			numero_productos--;
			return "Success";
		}else{
			return "HaHabidoUnError";
		}
	}
	
	public Articulo[] getLista(){
		return lista;
	}
	public void setLista(Articulo[] l){
		lista = l;
	}
	public int[] getCantidad(){
		return cantidad;
	}
	public void setCantidad(int[] c){
		cantidad = c;
	}
	public double getPrecioTotal(){
		return precioTotal;
	}
	public void setPrecioTotal(double p){
		precioTotal = p;
	}
	public int getNumero_Productos(){
		return numero_productos;
	}
	public void setNumero_Productos(int n){
		numero_productos = n;
	}
	
}

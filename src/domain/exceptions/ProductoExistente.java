package domain.exceptions;

public class ProductoExistente extends Exception {
	private static final long serialVersionUID = 1L;

	public ProductoExistente(String id) {
		super("El producto " + id + " ya existe en la base de datos");
	}
}

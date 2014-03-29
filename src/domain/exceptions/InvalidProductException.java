package domain.exceptions;

public class InvalidProductException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidProductException(String id) {
		super("No se ha encontrado " + id);
	}

}

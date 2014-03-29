package domain.exceptions;

public class ClienteExistente extends Exception {
	private static final long serialVersionUID = 1L;

	public ClienteExistente(String login) {
		super("El cliente " + login + " ya existe en la base de datos");
	}
}

package domain.exceptions;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserException(String login) {
		super("Error identifying " + login);
	}

}

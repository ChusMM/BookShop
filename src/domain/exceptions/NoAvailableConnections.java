package domain.exceptions;

public class NoAvailableConnections extends Exception {
	private static final long serialVersionUID = 1L;

	public NoAvailableConnections() {
		super("No available connection, connection limit exceed");
	}
}

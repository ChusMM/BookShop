package domain.tests;

import domain.identification.Cliente;

public class HiloUser implements Runnable {

	private String login;
	private String pass;
	private UserTest console;

	public HiloUser(String login, String password, UserTest userTest) {
		this.login = login;
		this.pass = password;
		this.console = userTest;
	}

	@Override
	public void run() {
		try {
			Cliente cli = Cliente.identify(this.login, this.pass);
			cli.insert();
		} catch (Exception e) {
			this.console.throwException(e);
		}
	}
	

}

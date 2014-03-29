package domain.tests;

//import java.sql.SQLException;
import java.util.Vector;

import junit.framework.TestCase;

import domain.exceptions.InvalidUserException;
import domain.identification.*;

public class UserTest extends TestCase {

	private Vector<Exception> exceptions;

	protected void setUp() throws Exception {
		this.exceptions=new Vector<Exception>();
	}

	public void testRightIdentification() {
		try {
			Cliente user= Cliente.identify("alicia", "*****");
			assertNotNull(user);
			assertTrue(user.getLogin().equals("alicia"));
		} 
		catch (Exception e) {
			fail("An unexpected exception has been launched: " + e.toString());
		}
	}
	
	public void testIncorrectIdentification() {
		try {
			Cliente cli = Cliente.identify("alicia", "***");
			cli.insert();
			fail("I expected an InvalidUserException");
		} 
		catch (InvalidUserException e) { } 
		catch (Exception e) {
			fail("I expected InvalidUserException but " + e.toString() + " has been thrown");
		}
	}
	
	public void testNonAvailableConnections() {
		Vector<Thread> hilos=new Vector<Thread>();
		
		for(int i = 0; i < 1000; i++) {
			HiloUser hilo = new HiloUser("alicia", "*****", this);
			Thread t = new Thread(hilo);
			hilos.add(t);
		}
		for (Thread t : hilos)
			t.start();
		assertTrue(this.exceptions.size()>1);
	}

	public void throwException(Exception e) {
		this.exceptions.add(e);
	}
}

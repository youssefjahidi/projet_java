package Users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void testGetMessage() {
		Customer c = new Customer("jean","j");
		c.addMessage("la");
		assertTrue(c.getMessage(0).equals("la"));
	}

	@Test
	void testGetLastMessage() {
		Customer c = new Customer("jean","j");
		c.addMessage("la");
		c.addMessage("ma");
		assertTrue(c.getLastMessage().equals("ma"));
	}

	@Test
	void testAddMessage() {
		Customer c = new Customer("jean","j");
		c.addMessage("la");
		assertTrue(c.getMessage(0).equals("la"));
	}
}

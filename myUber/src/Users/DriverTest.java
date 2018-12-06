package Users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DriverTest {

	@Test
	void testGetState() {
		Driver d = new Driver("jean","j");
		assertTrue(d.getState().equals(DriverState.offline));
	}

	@Test
	void testSetState() {
		Driver d = new Driver("jean","j");
		d.setState(DriverState.offDuty);
		assertTrue(d.getState().equals(DriverState.offDuty));
		}

}

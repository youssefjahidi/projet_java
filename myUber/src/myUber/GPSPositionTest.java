package myUber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GPSPositionTest {

	@Test
	void testDistance() {
		GPSPosition gps1 = new GPSPosition(0,0);
		GPSPosition gps2 = new GPSPosition(3,0);
		assertTrue(gps1.distance(gps2) == 3);
	}

	@Test
	void testEqual() {
		GPSPosition gps1 = new GPSPosition(1,0);
		GPSPosition gps2 = new GPSPosition(1,0);
		assertTrue(gps1.equal(gps2) );	}

}

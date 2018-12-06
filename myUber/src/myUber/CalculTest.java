package myUber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculTest {

	@Test
	void testHour() {
		System.out.println(Calcul.hour());
		assertTrue(true);
	}

	@Test
	void testDuration() {
		assertTrue(Calcul.duration(1,-1) == 13);
		// It depend of the hour of the day
	}

	@Test
	void testArrival_time() {
		System.out.println(Calcul.arrival_time(1));
		assertTrue(true);
	}

}

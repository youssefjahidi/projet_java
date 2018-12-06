package Car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarFactoryTest {

	@Test
	void testCreateCar() {
		CarFactory cf = new CarFactory();
		Car s = cf.createCar("Standard");
		Car b = cf.createCar("Berline");
		Car v = cf.createCar("Van");
		System.out.println(s.getId());
		assertTrue(
				(s.getId().equals("Standard1")) 
				&& (b.getId().equals("Berline1")) &&	(v.getId().equals("Van1"))
				);
		// TODO
	}

}

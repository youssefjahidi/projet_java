package Car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Users.Driver;

class CarTest {

	@Test
	void testCar() {
		Car car = new Car(3,"Berline1");
		assertTrue(car.getnbSeats()==3);// TODO
	}

	@Test
	void testAddDriver() {
		Car car = new Car(3,"Berline1");
		Driver d = new Driver("name","surname");
		car.addDriver(d);
		assertTrue(car.getDrivers().contains(d));
	}

}

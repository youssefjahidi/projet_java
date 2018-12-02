package myUber;

import static org.junit.Assert.*;

import org.junit.Test;

import Car.Berline;
import Car.Car;
import Car.CarFactory;
import Car.Standard;

public class MyUberTest extends MyUber {

	@Test
	public void testMoveCar1() {
		CarFactory carFactory = new CarFactory();
		Car standardcar1 = CarFactory.createCar("Standard");
		String id = standardcar1.getId();
		standardCars.put(id, (Standard) standardcar1);
		boolean bool = moveCar(id, -20, 30);
		assertTrue(bool && standardcar1.getGpsPositionX() == -20 && standardcar1.getGpsPositionY() == 30);
	}
	
	@Test
	public void testMoveCar2() {
		CarFactory carFactory = new CarFactory();
		Car berlinecar1 = CarFactory.createCar("Berline");
		String id = berlinecar1.getId();
		berlineCars.put(id, (Berline) berlinecar1);
		boolean bool = moveCar(id, 50, -50);
		assertTrue(bool && berlinecar1.getGpsPositionX() == 50 && berlinecar1.getGpsPositionY() == -50);
	}

}

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
		Car standardcar1 = carFactory.createCar("Standard");
		String id = standardcar1.getId();
		allCars.put(id, (Standard) standardcar1);
		GPSPosition gpspos = new GPSPosition(-20,30);
		boolean bool = moveCar(id, gpspos);
		assertTrue(bool && standardcar1.getGpsPosition().getX() == -20 && standardcar1.getGpsPosition().getY() == 30);
	}
	
	@Test
	public void testMoveCar2() {
		CarFactory carFactory = new CarFactory();
		Car berlinecar1 = carFactory.createCar("Berline");
		String id = berlinecar1.getId();
		allCars.put(id, (Berline) berlinecar1);
		GPSPosition gpspos = new GPSPosition(50,-50);
		boolean bool = moveCar(id, gpspos);
		assertTrue(bool && berlinecar1.getGpsPosition().getX()== 50 && berlinecar1.getGpsPosition().getY() == -50);
	}
	
	

}
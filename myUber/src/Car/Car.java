package Car;
import java.util.ArrayList;

import Users.Driver;

/**
 * This class represents the car in the uber system. It has a list of drivers, a GPS Position, 
 * an id and a number of places.
 *
 * @author Youssef Jahidi
 * 
 * @author Axel Vincent
 */
public class Car {
	/** 
	 * List of drivers that take turn in driving the car.
	 */
	private ArrayList<Driver> drivers;
	
	/** 
	 * x coordinate of the car's GPS Position.
	 */
	private float gpsPositionX;	
	
	/** 
	 * y coordinate of the car's GPS Position.
	 */
	private float gpsPositionY;	
	
	/** 
	 * Number of seats in the car.
	 */
	private int nbSeats;
	
	/** 
	 * Alphanumerical Id of the car in the format TypeN
	 */
	private String id;
	
	/**
	 * This constructor initializes the creation of a car given a number of seats and an id.
	 * 
	 * @param nbSeats The number of passengers' seats i the car.
	 * @param id Alphanumerical id of the car.
	 */
	public Car(int nbSeats, String id){
		this.nbSeats = nbSeats;
		this.drivers = new ArrayList<Driver>();
		this.id = id;
	}
	
	

	/**
	 * @return the gpsPositionX
	 */
	public float getGpsPositionX() {
		return gpsPositionX;
	}



	/**
	 * @param gpsPositionX the gpsPositionX to set
	 */
	public void setGpsPositionX(float gpsPositionX) {
		this.gpsPositionX = gpsPositionX;
	}



	/**
	 * @return the gpsPositionY
	 */
	public float getGpsPositionY() {
		return gpsPositionY;
	}



	/**
	 * @param gpsPositionY the gpsPositionY to set
	 */
	public void setGpsPositionY(float gpsPositionY) {
		this.gpsPositionY = gpsPositionY;
	}



	/**
	 * @return the drivers list
	 */
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

	/**
	 * @return the number of seats
	 */
	public int getnbSeats() {
		return nbSeats;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public  void addDriver(Driver driver){
		drivers.add(driver);
	};
	
	
	
}

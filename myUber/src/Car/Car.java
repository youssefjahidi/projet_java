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
	 * Coordinate of the car's GPS Position.
	 */
	private GPSPosition gpsPosition;
	
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
	 * @return the gpsPosition
	 */
	public GPSPosition getGpsPosition() {
		return gpsPosition;
	}



	/**
	 * @param gpsPosition the gpsPosition to set
	 */
	public void setGpsPosition(GPSPosition gpsPosition) {
		this.gpsPosition = gpsPosition;
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

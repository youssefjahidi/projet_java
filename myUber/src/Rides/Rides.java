package Rides;



import java.util.ArrayList;

import Car.Car;
import Users.Customer;
import Users.Driver;
import myUber.Calcul;
import myUber.GPSPosition;


public class Rides implements Observable{
	
	private Customer customer;
	private Driver driver;
	private Car car;
	private String rideId;
	private GPSPosition startingPoint;
	private GPSPosition destination;
	private String pickupTime;
	private String arrivalTime;
	private double length; 
	private int duration; 
	private int nbPassengers;
	private RideStatus state;
	private RideType type;
	private RideEvaluationMark mark;
	
	
	public Rides(Customer customer, GPSPosition destination, RideType rideType, String id) {
		this.customer = customer;
		this.destination = destination;
		this.state = RideStatus.unconfirmed;
		this.type = rideType;
		this.rideId = id;
		//this.length = Calcul.distance(customer.getGPS(), destination);
		//this.duration = Calcul.duree(length);
		}
	

	
	
	
	/*public void setunconfirmed();
	public void setconfirmed();
	public void setongoing();
	public void setcanceled();
	public void setcompleted();
	
	public void request();
	public void cancel();
	public void note(int note);
	
	public double accept(UberVisitor visitor);
	public void prepare(Customer customer, String destination, int nbpersonne);*/

}

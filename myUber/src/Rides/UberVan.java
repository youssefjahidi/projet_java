package Rides;

import Car.*;
import Users.Customer;
import Users.Driver;
import myUber.Calcul;
import myUber.GPSPosition;
import myUber.UberVisitor;

public class UberVan implements Rides {

	private Customer customer;
	private GPSPosition destination;
	private Driver driver;
	private Car car;
	private double length; // la longueur de la course
	private int duration; // la durée de la course
	private int nbpersonne;
	private String state;
	private String boardingtime;
	private String landingtime;

	@Override
	public void prepare(Customer customer, GPSPosition destination, int nbpersonne, int hour) {
		this.customer = customer;
		this.destination = destination;
		this.state = "unconfirmed";
		this.nbpersonne = nbpersonne;
		this.length = customer.getGpsPosition().distance( destination);
		 Calcul.duration(length,hour);
		}

	@Override
	public GPSPosition getdestination() {
		return this.destination;
	}

	@Override
	public Customer getcustomer() {
		return this.customer;
	}
	@Override
	public double getlength() {
		return this.length;
	}

	
	@Override
	public void setunconfirmed() {
		this.state = "unconfirmed";
	}

	@Override
	public void setconfirmed() {
		this.state= "confirmed";
	}

	@Override
	public void setongoing() {
		this.state= "ongoing";
	}

	@Override
	public void setcanceled() {
		this.state = "canceled";
		
	}

	@Override
	public void setcompleted() {
		this.state = "completed";
		
	}

	@Override
	public double accept(UberVisitor visitor) {
		return visitor.visit(this);
	}
	
	/*
	@Override
	public void request() {
		for(Van van: Van.V_exist){
			double distancechauffeur = Calcul.distance(this.car.getGpsPositionX(), this.car.getGpsPositionY(),
					this.customer.getGpsPositionX(), this.customer.getGpsPositionY());
			if( distancechauffeur <5 && this.nbpersonne<= van.getnbSeats() ){
				Driver d = van.contact(this.customer.getName(),distancechauffeur,this.length);
				if(d != null) {
					this.car = van;
					this.driver = d;
					break;
					};
			}
		}
		if(this.car ==null) {System.out.println("Pas de conducteur disponible");}
		else {double distchauffeur = Calcul.distance(this.car.getGpsPositionX(), this.car.getGpsPositionY(),
				this.customer.getGpsPositionX(), this.customer.getGpsPositionY());
			System.out.println("Nous avons trouvé un chauffeur. \n "
				+ "Il arrive dans " + Calcul.duration(distchauffeur)+ "\n"
				+ "Arrivé à destination prévue à : " + Calcul.arrival_time(distchauffeur + this.length));

			this.setconfirmed();
			this.driver.setonaride();
			this.boardingtime = Calcul.arrival_time(distchauffeur);
			this.landingtime = Calcul.arrival_time(distchauffeur+length);
			
			Rides.BookOfRides.add("Driver : " + this.driver.getID() + "\n" +
					"CarID : " + this.car.getId() + "\n" +
					"customer : " + this.customer.getID() + "\n" + 
					"Starting point : " + this.customer.getGPS() + "\n" + 
					"Ending point : " + this.destination + "\n" + 
					"Starting time : " + this.boardingtime + "\n" +
					"Ending time : " + this.landingtime 
					);
			}

	}
	
	@Override
	public void cancel() {
		this.driver.setonduty();
		this.setcanceled();
	}
	@Override
	public void note(int note) {
		this.driver.note(note);
	}
*/
}

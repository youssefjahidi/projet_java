package Rides;

import Car.Berline;
import Users.Customer;
import Users.Driver;
import myUber.Calcul;
import myUber.UberVisitor;

public class UberBlack implements Rides {
	private Customer customer;
	private String destination;
	private Driver driver;
	private Car car;
	private double length; // la longueur de la course
	private int duration; // la durée de la course
	private int nbpersonne;
	private String state;
	private String boardingtime;
	private String landingtime;

	@Override
	public void prepare(Customer customer, String destination, int nbpersonne) {
		this.customer = customer;
		this.destination = destination;
		this.state = "unconfirmed";
		this.nbpersonne = nbpersonne;
		this.length = Calcul.distance(customer.getGPS(), destination);
		this.duration = Calcul.durée(length);
		}

	@Override
	public String getdestination() {
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
	
	@Override
	public void request() {
		for(Berline berline: Berline.B_exist){
			double distancechauffeur = Calcul.distance(berline.getGPS(), this.customer.getGPS());
			if(distancechauffeur <10 && this.nbpersonne<= berline.getnbplace() ){
				Driver d = berline.contact(this.customer.getName(),distancechauffeur,this.length);
				if(d != null) {
					this.car = berline;
					this.driver = d;
					break;
					};
			}
		}
		if(this.car ==null) {System.out.println("Pas de conducteur disponible");}
		else {double distchauffeur = Calcul.distance(this.car.getGPS(), this.customer.getGPS());
			System.out.println("Nous avons trouvé un chauffeur. \n "
				+ "Il arrive dans " + Calcul.durée(distchauffeur)+ "min \n"
				+ "Arrivé à destination prévue à : " + Calcul.temps(distchauffeur + this.length));

			this.setconfirmed();
			this.driver.setonaride();
			this.boardingtime = Calcul.temps(distchauffeur);
			this.landingtime = Calcul.temps(distchauffeur+length);
			
			Rides.BookOfRides.add("Driver : " + this.driver.getID() + "\n" +
					"CarID : " + this.car.getID() + "\n" +
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
	
}

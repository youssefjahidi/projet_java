package myUber;

public class UberBlack implements Rides {
	private Customer customer;
	private String destination;
	private Driver driver;
	private Car car;
	private double length; // la longueur de la course
	private String time; // l'heure actuelle
	private int duration; // la durée de la course
	private int nbpersonne;
	private String state;

	@Override
	public void prepare(Customer customer, String destination, int nbpersonne, String time) {
		this.customer = customer;
		this.destination = destination;
		this.state = "unconfirmed";
		this.nbpersonne = nbpersonne;
		this.length = Calcul.distance(customer.getGPS(), destination);
		this.time = time;
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
	public String gettime() {
		return this.time;
	}
	
	@Override
	public void request() {
		// TODO Auto-generated method stub

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
}

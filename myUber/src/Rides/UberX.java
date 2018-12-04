package Rides;

import Car.*;
import Users.Customer;
import Users.Driver;
import myUber.Calcul;
import myUber.GPSPosition;
import myUber.UberVisitor;

public class UberX extends Rides {

	public UberX(Customer customer, GPSPosition destination, int idAct){
		super(customer, destination, uberX, "UberX" + (String) Integer.toString(idAct));
		
	

	}
	@Override
	public double accept(UberVisitor visitor) {
		return visitor.visit(this);
	}
	@Override
	public void request() {
		for(Standard standard: Standard.S_exist){
			double distdriver = Calcul.distance(this.car.getGpsPositionX(), this.car.getGpsPositionY(),
					this.customer.getGpsPositionX(), this.customer.getGpsPositionY());
			if(distdriver <5 && this.nbpersonne<= standard.getnbSeats() ){
				Driver d = standard.contact(this.customer.getName(),distdriver,this.length);
				if(d != null) {
					this.car = standard;
					this.driver = d;
					break;
					};
			}
		}
		if(this.car ==null) {System.out.println("Pas de conducteur disponible");}
		else {double distdriver = Calcul.distance(this.car.getGpsPositionX(), this.car.getGpsPositionY(),
				this.customer.getGpsPositionX(), this.customer.getGpsPositionY());
			System.out.println("Nous avons trouvé un chauffeur. \n "
				+ "Il arrive dans " + Calcul.duration(distdriver)+ "\n"
				+ "Arrivé à destination prévue à : " + Calcul.arrival_time(distdriver + this.length));
			this.setconfirmed();
			this.driver.setonaride();
			this.boardingtime = Calcul.arrival_time(distdriver);
			this.landingtime = Calcul.arrival_time(distdriver+length);
			
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
}

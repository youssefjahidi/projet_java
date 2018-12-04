package Users;
import java.util.ArrayList;
import java.util.Scanner;

import Rides.Rides;
import Rides.RidesFactory;
import myUber.GPSPosition;
//import myUber.ConcreteUberVisitor;
//import myUber.UberVisitor;

public class Customer extends User{

	private GPSPosition gpsPosition;
	private int creditcardnumb;
	private ArrayList<String> messagebox;
	private static int  idact;
	private int nbmess;
	private String destination;
	
	Customer(String name, String surname, int credicardnumb){
		super(name, surname, Customer.idact);
		this.creditcardnumb = credicardnumb;
		messagebox = new ArrayList<String>();
		idact ++;
		this.nbmess = 0;
	}

	/**
	 * @return the gpsPosition
	 */
	public GPSPosition getGpsPosition() {
		return gpsPosition;
	}



	/**
	 * @param gpsPositionX the gpsPositionX to set
	 */
	public void setGpsPositionX(GPSPosition gpsPosition) {
		this.gpsPosition = gpsPosition;
	}
	
	/**
	 * @return  gpsPosition of the current destination
	 */
	public String getdestination() {
		return this.destination;
	}
	
	/**
	 * @return the creditcardnum
	 */
	public int getcreditcardnumb() {
		return this.creditcardnumb;
	}
	
	/**
	 * @param i the index of the message to get
	 * @return The message with the index i in the messagebox
	 */
	public String getMessage(int i) {
		return (String) messagebox.get(i);
	}
	
	/**
	 * @return the last message given
	 */
	public String getLastMessage() {
		return (String) messagebox.get(nbmess);
	}
	
	/**
	 * @param message the message that is added to messagebox
	 */
	public void addMessage(String message) {
		messagebox.add(message);
		nbmess ++;
	}
	/*public void request(String destination) {	
		this.destination = destination;
		Rides uberX = RidesFactory.createRides("UberX");
		uberX.prepare(this, destination,0);
		Rides uberVan = RidesFactory.createRides("UberVan");
		uberVan.prepare(this, destination,0);
		Rides uberPool = RidesFactory.createRides("UberPool");
		uberPool.prepare(this, destination,0);
		Rides uberBlack = RidesFactory.createRides("UberBlack");
		uberBlack.prepare(this, destination,0);
		
		UberVisitor visitor = new ConcreteUberVisitor();
		System.out.println( "UberX : " + uberX.accept(visitor) +"\n" + 
							"UberVan : " + uberVan.accept(visitor) +"\n" +
							"UberPool : " + uberPool.accept(visitor) +"\n" +
							"UberBlack : " + uberBlack.accept(visitor) 
				);
	}
	
	
	
	public void cancel() {
		this.rides.cancel();  dans myuber
	}
	public void note(int note) {
		this.rides.note(note);  dans my uber
	}*/
}

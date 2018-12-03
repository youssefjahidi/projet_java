package Users;
import java.util.ArrayList;
import java.util.Scanner;

import Rides.Rides;
import Rides.RidesFactory;
//import myUber.ConcreteUberVisitor;
//import myUber.UberVisitor;

public class Customer extends User{

	private String GPS;
	private int creditcardnumb;
	private ArrayList<String> messagebox;
	private static int  idact;
	private int nbmess;
	private String destination;
	
	Customer(String name, String surname, String GPS, int credicardnumb){
		super(name, surname, Customer.idact);
		this.GPS = GPS;
		this.creditcardnumb = credicardnumb;
		messagebox = new ArrayList<String>();
		idact ++;
		this.nbmess = 0;
	}

	public String getGPS() {
		return this.GPS;
	}
	public String getdestination() {
		return this.destination;
	}
	public int getcreditcardnumb() {
		return this.creditcardnumb;
	}
	public String getMessage(int indice) {
		return (String) messagebox.get(indice);
	}
	public String getLastMessage() {
		return (String) messagebox.get(nbmess);
	}
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

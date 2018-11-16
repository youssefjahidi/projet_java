package myUber;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private String name;
	private String surname;
	private int ID;
	private String GPS;
	private int creditcardnumb;
	private ArrayList<String> messagebox;
	private static int  IDact;
	private int nbmess;
	private String destination;
	private Rides rides;
	
	Customer(String name, String surname, String GPS, int credicardnumb){
		this.name = name;
		this.surname = surname;
		this.GPS = GPS;
		this.creditcardnumb = credicardnumb;
		messagebox = new ArrayList<String>();
		this.ID = IDact;
		IDact ++;
		this.nbmess = 0;
	}
	public String getName() {
		return this.name;
	}
	public String getSurname() {
		return this.surname;
	}
	public int getID() {
		return this.ID;
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
	public void request(String destination) {	
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
	
	public void choose() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel type de course choisissez vous?");
		String RidesType = sc.nextLine();
		System.out.println("Combien êtes vous?");
		int nbpersonne = sc.nextInt();
		Rides ride = RidesFactory.createRides(RidesType);
		ride.prepare(this,this.destination, nbpersonne);
		ride.request();	
		this.rides = ride;
	}
	
	public void cancel() {
		this.rides.cancel();
	}

	public void note(int note) {
		this.rides.note(note);
	}
}

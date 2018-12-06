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
	private GPSPosition destination;
	

	public Customer(String name, String surname){
		super(name, surname, Customer.idact);
		messagebox = new ArrayList<String>();
		idact ++;
		this.nbmess = -1;
	}
	
	public Customer(String name, String surname, int credicardnumb){
		super(name, surname, Customer.idact);
		this.creditcardnumb = credicardnumb;
		messagebox = new ArrayList<String>();
		idact ++;
		this.nbmess = -1;
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
	public void setGpsPosition(GPSPosition gpsPosition) {
		this.gpsPosition = gpsPosition;
	}
	
	/**
	 * @return  gpsPosition of the current destination
	 */
	public GPSPosition getdestination() {
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

}
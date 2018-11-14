package myUber;
import java.util.ArrayList;

public class Customer {
	private String name;
	private String surname;
	private int ID;
	private String GPS;
	private int creditcardnumb;
	private ArrayList messagebox;
	private static int  IDact;
	private int nbmess;
	
	Customer(String name, String surname, String GPS, int credicardnumb){
		this.name = name;
		this.surname = surname;
		this.GPS = GPS;
		this.creditcardnumb = credicardnumb;
		messagebox = new ArrayList();
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
		
	}
	public void choose() {
		
	}
}

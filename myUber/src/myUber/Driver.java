package myUber;

import java.util.Scanner;

public class Driver {
	private String name;
	private String surname;
	private int ID;
	private String state;
	private static int IDact;
	
	Driver(String name, String surname){
		this.name = name;
		this.surname = surname;
		this.ID = Driver.IDact;
		IDact ++;
		state = "offline";
	}
	public String getname() {
		return this.name;
	}
	public String getsurname() {
		return this.surname;
	}
	public int getID() {
		return this.ID;
	}
	public String getState() {
		return this.state;
	}
	public void setoffline(String St) {
		this.state = "offline";
	}
	public void setonduty(String St) {
		this.state = "onduty";
	}
	public void setonaride(String St) {
		this.state = "onaride";
	}
	public void setoffduty(String St) {
		this.state = "offduty";
	}
	public boolean contact() {
		// Il faudra ajouter dans la demande: le nombre de personne, la distance a 
		// la personne, la distance de la course, le prix, le nom de la personne
		System.out.println("Voulez vous accepter la course ?");	
		Scanner sc = new Scanner(System.in);
		String rep = sc.nextLine();
		while(!(rep.equals("oui") || rep.equals("non"))) {
			System.out.println("Vous devez répondre oui ou non"
					+ " \nVoulez vous accepter la course ?");
			rep = sc.nextLine();
		}
		if (rep.equals("oui")) {
			return true;
		}
		return false;
		
		
	}
	
	
}

package myUber;

import java.util.Scanner;

public class Driver {
	private String name;
	private String surname;
	private int ID;
	private String state;
	private static int IDact;
	int note;
	int nbcourse;
	
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
	public void setoffline() {
		this.state = "offline";
	}
	public void setonduty() {
		this.state = "onduty";
	}
	public void setonaride() {
		this.state = "onaride";
	}
	public void setoffduty() {
		this.state = "offduty";
	}
	public boolean contact(String nom, double distchauffeur,double length) {
		System.out.println(nom + " souhaite monter avec vous. Il / elle est à "
				+ distchauffeur + "km. Elle souhaite parcourir : " + length);
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
	
	public void note(int note) {
		this.note = (this.note*nbcourse +note) /(nbcourse+1);
		nbcourse++;
	}
	
}

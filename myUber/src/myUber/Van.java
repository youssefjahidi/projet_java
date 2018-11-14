package myUber;
import java.util.ArrayList;

public class Van implements Car {
	private ArrayList<Driver> drivers;
	private String GPS;	
	private static int IDact;
	private static ArrayList<Van> V_exist;
	private int nbplaces;
	private String ID;
	
	public Van(String GPS) {
		this.GPS = GPS;
		this.drivers = new ArrayList<Driver>();
		this.nbplaces = 6;
		IDact ++;
		ID = "Van" + (String) Integer.toString(IDact);
		V_exist.add(this);
		}

	@Override
	public void contact() {
		// TODO Auto-generated method stub
	}
	public static void main(String[] args){
		Van.initializeList();
		Van V = new Van("earth");
		Van V2 = new Van("la");
		V_exist.add(V);
		System.out.println(V.getID() + V2.getID() + V2.getGPS());
	}

	@Override
	public void addDriver(Driver driver) {
		this.drivers.add(driver);	
	}

	@Override
	public String getGPS() {
		return this.GPS;
	}

	public static void initializeList() {
		Van.V_exist = new ArrayList<Van>();
	}

	@Override
	public String getID() {
		return this.ID;
	}

	@Override
	public int getnbplace() {
		return this.nbplaces;
	}

}

package myUber;
import java.util.ArrayList;

public class Berline implements Car {
	private ArrayList<Driver> drivers;
	private String GPS;	
	private static int IDact;
	private static ArrayList<Berline> B_exist;
	private int nbplaces;
	private String ID;
	
	public Berline(String GPS) {
		this.GPS = GPS;
		this.drivers = new ArrayList<Driver>();
		this.nbplaces = 4;
		IDact ++;
		ID = "Berline" + (String) Integer.toString(IDact);
		B_exist.add(this);
	}

	@Override
	public void contact() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDriver(Driver driver) {
		this.drivers.add(driver);	
		
	}

	@Override
	public String getGPS() {
		return this.GPS;
	}
	
	@Override
	public String getID() {
		return this.ID;
	}

	@Override
	public int getnbplace() {
		return this.nbplaces;
	}

	public static void initializeList() {
		Berline.B_exist = new ArrayList<Berline>();
	}

}

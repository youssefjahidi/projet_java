package myUber;
import java.util.ArrayList;

public class Berline implements Car {
	private ArrayList<Driver> drivers;
	private String GPS;	
	private static int IDact;
	private static ArrayList<Berline> B_exist;
	private int nbplaces;
	private String ID;
	
	@Override
	public void create(String GPS) {
		this.GPS = GPS;
		this.drivers = new ArrayList<Driver>();
		this.nbplaces = 4;
		IDact ++;
		ID = "Berline" + (String) Integer.toString(IDact);
		B_exist.add(this);
	}
	
	@Override
	public boolean contact() {
		for(Driver driver: drivers){
			if(driver.getState().equals("onduty")){
				return driver.contact();
			}
		}
		return false;
		
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

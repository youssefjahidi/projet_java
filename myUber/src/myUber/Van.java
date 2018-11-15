package myUber;
import java.util.ArrayList;

public class Van implements Car {
	private ArrayList<Driver> drivers;
	private String GPS;	
	private static int IDact;
	private static ArrayList<Van> V_exist;
	private int nbplaces;
	private String ID;
	
	@Override
	public void create(String GPS) {
		this.GPS = GPS;
		this.drivers = new ArrayList<Driver>();
		this.nbplaces = 6;
		IDact ++;
		ID = "Van" + (String) Integer.toString(IDact);
		V_exist.add(this);
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


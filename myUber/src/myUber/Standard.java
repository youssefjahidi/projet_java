package myUber;
import java.util.ArrayList;

public class Standard implements Car {
	private ArrayList<Driver> drivers;
	private String GPS;	
	private static int IDact;
	public static ArrayList<Standard> S_exist = new ArrayList<Standard>();
	private int nbplaces;
	private String ID;
	

	@Override
	public void create(String GPS) {
		this.GPS = GPS;
		this.drivers = new ArrayList<Driver>();
		this.nbplaces = 4;
		ID = "Standard" + (String) Integer.toString(IDact);
		IDact ++;
		S_exist.add(this);
	}


	@Override
	public Driver contact(String nom, double distchauff,double length) {
		for(Driver driver: drivers){
			if(driver.getState().equals("onduty")){
				if(driver.contact(nom, distchauff, length)) {return driver;}
			}
		}
		return null;
		
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
		Standard.S_exist = new ArrayList<Standard>();
	}


}

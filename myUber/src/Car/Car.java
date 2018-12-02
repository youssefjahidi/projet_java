package Car;
import java.util.ArrayList;

import Users.Driver;


public class Car {
	
	private ArrayList<Driver> drivers;
	private String gpsPosition;	
	private int nbPlaces;
	private String id;
	
	public Car(int nbPlaces, String id){
		this.nbPlaces = nbPlaces;
		this.drivers = new ArrayList<Driver>();
		this.id = id;
		this.gpsPosition = "";
	}
	
	/**
	 * @return the gpsPosition
	 */
	public String getGpsPosition() {
		return gpsPosition;
	}

	/**
	 * @param gpsPosition the gpsPosition to set
	 */
	public void setGpsPosition(String gpsPosition) {
		this.gpsPosition = gpsPosition;
	}

	/**
	 * @return the drivers
	 */
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

	/**
	 * @return the nbPlaces
	 */
	public int getNbPlaces() {
		return nbPlaces;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public  void addDriver(Driver driver){
		drivers.add(driver);
	};
	
	public  Driver contact(String nom, double distchauff,double length){
		for(Driver driver: drivers){
			if(driver.getState().equals("onduty")){
				if(driver.contact(nom, distchauff, length)) {return driver;}
			}
		}
		return null;
	};


}

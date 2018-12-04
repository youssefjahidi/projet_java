package myUber;
import java.util.ArrayList;
import java.util.HashMap;

import Car.*;
import Rides.*;
import Users.*;

/**
 * Client app
 * @author Youssef
 *
 */

public class MyUber {
	
	//public static ArrayList<Standard> S_exist = new ArrayList<Standard>();
	
	/*public  Driver contact(String nom, double distchauff,double length){
		for(Driver driver: drivers){
			if(driver.getState().equals("onduty")){
				if(driver.contact(nom, distchauff, length)) {return driver;}
			}
		}
		return null;
	};*/
	/**
	 * Customer hashmap indexed by customer id
	 */
	public static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();

	/**
	 * Customer hashmap indexed by customer id
	 */
	public static HashMap<String[], Driver> drivers = new HashMap<String[], Driver>();

	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Standard> standardCars = new HashMap<String, Standard>();
	
	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Berline> berlineCars = new HashMap<String, Berline>();
	
	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Van> vanCars = new HashMap<String, Van>();
	
	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Car> allCars = new HashMap<String, Car>();
	
	private CarFactory carFactory = new CarFactory();
	
	/**
	 * Add a Customer in the system
	 * @param name of the Customer
	 * @param surname of the Customer
	 */
	public void addCustomer(String name,String surname) {
		Customer customer = new Customer(name,surname);
		MyUber.customers.put(customer.getId(), customer);
		for (int key : MyUber.customers.keySet()) {
			System.out.println("The " + key + " customer is " + 
					MyUber.customers.get(key).getName() );
			}
	}
	
	/**
	 * Add a Car and a Driver and associate them
	 * @param Drivername the name of the driver
	 * @param Driversurname the surname of the driver
	 * @param carType the type of the car
	 */
	public void addCarDriver(String Drivername,String Driversurname,String carType) {
		Driver driver = new Driver(Drivername, Driversurname);
		Car car = carFactory.createCar(carType);
		car.addDriver(driver);
		driver.setCar(car);
		String[] s = {Drivername,Driversurname};
		MyUber.drivers.put(s, driver);
		MyUber.allCars.put(car.getId(),car);
		// Est ce que les vanCars/BerlineCar etc. sont vraiment utiles ? On pourrait simplement parcourir 
		// allCars et checker si l'ID commence par van/berline etc. non ? Sinon c'est un peu chiant pour
		// ajouter chaque nouvelle voiture une fois crée dans la bonne liste
		// Et c'est un peu redondant		
		for (String key : MyUber.allCars.keySet()) {
			System.out.println("The car : " + key + " is associated with the following Driver : \n");
					for (Driver driverofcar : MyUber.allCars.get(key).getDrivers()) {
						System.out.println( "   " + driverofcar.getName()+" "+ driverofcar.getSurname()+ "\n");
					};
			}
	}
	
	/**
	 * Add a Driver and associate it with an existing Car
	 * @param Drivername the name of the driver
	 * @param Driversurname the surname of the driver
	 * @param carID the ID of the car
	 */
	public void addDriver(String Drivername, String Driversurname,String carID) {
		Driver driver = new Driver(Drivername, Driversurname);
		Car car = MyUber.allCars.get(carID);
		driver.setCar(car);
		String[] s = {Drivername,Driversurname};
		MyUber.drivers.put(s, driver);
		for (String key : MyUber.allCars.keySet()) {
			System.out.println("The car : " + key + " is associated with the following Driver : \n");
					for (Driver driverofcar : MyUber.allCars.get(key).getDrivers()) {
						System.out.println( "   " + driverofcar.getName()+" "+ driverofcar.getSurname()+ "\n");
					};
			}
	}
	
	/**
	 * Add a Driver and associate it with an existing Car
	 * @param Drivername the name of the driver
	 * @param Driversurname the surname of the Driver
	 * @param status the status of the driver to be set
	 */
	public void setDriverStatus(String Drivername, String Driversurname,String status) {
		DriverState state = DriverState // je sais pas comment manipuler les enum, mais j'ai 
				// l'impression que c'est pas super pratique après des rapides recherches
				// Tu pourras voir comment gérer ça ?
		String[] s = {Drivername,Driversurname};
		MyUber.drivers.get(s).setState(state);
		for (String key : MyUber.allCars.keySet()) {
			System.out.println("The car : " + key + " is associated with the following Driver : \n");
					for (Driver driverofcar : MyUber.allCars.get(key).getDrivers()) {
						System.out.println( "   " + driverofcar.getName()+" "+ driverofcar.getSurname()+ "\n");
					};
			}
	}
	
	/**
	 * Change car's gps position
	 * @param carId car id 
	 * @param posX x coordinate
	 * @param posY y coordinate
	 * @return Boolean: true if id found and coordinates inside the bounds, else returns false.
	 */
	public boolean moveCar(String carId, GPSPosition gpsPosition){
		allCars.putAll(standardCars);
		allCars.putAll(berlineCars);
		allCars.putAll(vanCars);		
		if(allCars.containsKey(carId) && Math.abs(gpsPosition.getX())<=50 && Math.abs(gpsPosition.getY())<=50 ){
			allCars.get(carId).setGpsPosition(gpsPosition);
			return true;}
		else{return false;}
	}

	
	public boolean setup(int nBerlineCar,int nVanCar, int nCustomer) {
		return true;
	}
}

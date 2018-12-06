package myUber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Car.*;
import Rides.*;
import Users.*;

/**
 * Client app
 * @author Youssef
 *
 */

public class MyUber {	

	/**
	 * Customer hashmap indexed by customer id
	 */
	public static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();

	/**
	 * Customer hashmap indexed by driver name and surname
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
	
	public void init(String fileName) {
		
	}
	
	/**
	 * Setup the environment with cars and customer
	 * @param nStandardCar the number of Standard car
	 * @param nBerlineCar the number of Berline
	 * @param nVanCar the number of Van
	 * @param nCustomer the number of customer
	 */
	public void setup(int nStandardCar, int nBerlineCar,int nVanCar, int nCustomer) {
		for(int i= 0;  i < nStandardCar; i++) {
			addCarDriver("Driver" + i+ "nameS", "Driver" + i+ "surnameS", "Standard");
		}
		for(int i= 0;  i < nBerlineCar; i++) {
			addCarDriver("Driver" + i+ "nameB", "Driver" + i+ "surnameB", "Standard");
		}
		for(int i= 0;  i < nVanCar; i++) {
			addCarDriver("Driver" + i+ "nameV", "Driver" + i+ "surnameV", "Standard");
		}
		for(int i= 0;  i < nCustomer; i++) {
			addCustomer("Customer" + i+ "name", "Customer" + i+ "surname");
		}
	}
	
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
		String[] s = {Drivername,Driversurname};
		MyUber.drivers.get(s).setState(DriverState.valueOf(status));
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
	public boolean moveCustomer(String customerId, GPSPosition gpsPosition){		
		if(customers.containsKey(customerId) && Math.abs(gpsPosition.getX())<=50 && Math.abs(gpsPosition.getY())<=50 ){
			customers.get(customerId).setGpsPosition(gpsPosition);
			for (Integer key : customers.keySet()) {
				System.out.println("The customer : " + key + 
					" is named " + customers.get(key).getName() + "and has made " +
					customers.get(key).getNbRides() + "rides"
						);
				}
			return true;}
		else{return false;}
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
		if(allCars.containsKey(carId) && Math.abs(gpsPosition.getX())<=50 && Math.abs(gpsPosition.getY())<=50 )
		{
			allCars.get(carId).setGpsPosition(gpsPosition);
			for (String key : MyUber.allCars.keySet()) {
				System.out.println("The car : " + key + " is associated with the following Driver : \n");
						for (Driver driverofcar : MyUber.allCars.get(key).getDrivers()) {
							System.out.println( "   " + driverofcar.getName()+" "+ driverofcar.getSurname()+ "\n");
						};
				};
			return true;}
		else{return false;}
	}
	
	public void displayState() {
		for (String key : MyUber.allCars.keySet()) {
			System.out.println("The car : " + key + " is associated with the following Driver : \n");
					for (Driver driverofcar : MyUber.allCars.get(key).getDrivers()) {
						System.out.println( "   " + driverofcar.getName()+" "+ driverofcar.getSurname()+ "\n");
					};
			};

		for (Integer key : customers.keySet()) {
			System.out.println("The customer : " + key + 
				" is named " + customers.get(key).getName() + "and has made " +
				customers.get(key).getNbRides() + "rides"
					);
			};
	}
	
	
	public void ask4price(int custID, GPSPosition destination,int time) {
		Customer customer = customers.get(custID);
		Rides uberX = RidesFactory.createRides("UberX");
		uberX.prepare(customer, destination,0,time);
		Rides uberVan = RidesFactory.createRides("UberVan");
		uberVan.prepare(customer, destination,0,time);
		Rides uberPool = RidesFactory.createRides("UberPool");
		uberPool.prepare(customer, destination,0,time);
		Rides uberBlack = RidesFactory.createRides("UberBlack");
		uberBlack.prepare(customer, destination,0,time);
		UberVisitor visitor = new ConcreteUberVisitor();
		System.out.println( "UberX : " + uberX.accept(visitor) +"\n" + 
							"UberVan : " + uberVan.accept(visitor) +"\n" +
							"UberPool : " + uberPool.accept(visitor) +"\n" +
							"UberBlack : " + uberBlack.accept(visitor) 
				);
	}
	
	/**
	 * Simulates a rides with the given options
	 * @param custID the ID of the customer
	 * @param destination the destination of the rides
	 * @param time the hour when the customer wants to take the ride
	 * @param rideType the type of ride wanted by the customer
	 * @param driverMark the mark given by the customer to the driver
	 */
	public Driver simRide_basis(int custID, GPSPosition destination, int time, String rideType) {
		Rides ride = RidesFactory.createRides(rideType);
		String carType;
		Car car = null;
		Driver driver = null;
		double distdriver = 0;
		Customer customer = customers.get(custID);
		ride.prepare(customer,destination,0,time);
		if(rideType.equalsIgnoreCase("UberX") || rideType.equalsIgnoreCase("UberPool") ) {
			carType = "Standard";
		}
		if(rideType.equalsIgnoreCase("UberBlack")) {
			carType = "Berline";
		}
		if(rideType.equalsIgnoreCase("UberVan")) {
			carType = "Van";
		}
		else carType = "";
		
		for(String key : allCars.keySet()) {
			System.out.println(key);
			car = allCars.get(key);
			String key2 = key;
			if(key2.indexOf(carType) ==0) {
				distdriver = customer.getGpsPosition().distance(car.getGpsPosition());
				if(distdriver < 15 && (Calcul.arrival_hour(distdriver) < time || time ==-1) ) {
					driver = car.contact();
					if(driver != null) {break;}
				}
			}
		}
		if(driver == null){System.out.println("Pas de conducteur disponible");}
		else if(time == -1) {
			System.out.println("Nous avons trouvé un chauffeur. \n "
					+ "Il arrive dans " + Calcul.duration(distdriver,-1)+ "min \n");
		}
		else {System.out.println("Nous avons trouvé un chauffeur. \n ");}
		
		UberVisitor visitor = new ConcreteUberVisitor();
		double price = ride.accept(visitor);
		String departure_time;
		if( time == -1 ) {departure_time = Calcul.arrival_time(distdriver);}
		else {departure_time = (String) Integer.toString(time);}
		
		String info = "Driver : " + driver.getId() + "\n" +
				"CarID : " + car.getId() + "\n" +
				"customer : " + customer.getId() + "\n" + 
				"Starting point : " + customer.getGpsPosition() + "\n" + 
				"Ending point : " + destination + "\n" + 
				"Price : "  + price + "\n" +
				"Starting time : " + departure_time + "\n" +
				"Ending time : " + Calcul.arrival_time(ride.getlength(), departure_time);
		Rides.BookOfRides.add(info);
		System.out.println(info);
		driver.addMoney(price);
		return driver;
	}
	
	public void simRide(int custID, GPSPosition destination, int time, String rideType, float driverMark) {
		Driver driver = simRide_basis(custID, destination, time, rideType);
		driver.addRating(driverMark);

	}
	
	
	public void simRide_i(int custID,GPSPosition destination, int time) {
		
		ask4price(custID, destination, time);
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel type de course choisissez vous?");
		String rideType = sc.nextLine();
		
		
		Driver driver = simRide_basis(custID,destination,time, rideType);
		float mark = sc.nextFloat();
		driver.addRating(mark);
		
		for (String key : MyUber.allCars.keySet()) {
			System.out.println("The car : " + key + " is associated with the following Driver : \n");
					for (Driver driverofcar : MyUber.allCars.get(key).getDrivers()) {
						System.out.println( "   " + driverofcar.getName()+" "+ driverofcar.getSurname()+ "\n");
					};
			};

		for (Integer key : customers.keySet()) {
			System.out.println("The customer : " + key + 
				" is named " + customers.get(key).getName() + "and has made " +
				customers.get(key).getNbRides() + "rides"
					);
			};
	}
	
	public void totalCashed() {
		double total = 0;
		for (String[] key : drivers.keySet()) {
			Driver driver = drivers.get(key);
			total += driver.getTotalMoney();
		}
		System.out.println(total);
	}
	
	


}

package myUber;

import java.util.ArrayList;
import java.util.Scanner;

import Users.Customer;


/**
 * This class communicates with the user through command lines
 * 
 * @author Youssef Jahidi
 * 
 * @author Axel Vincent
 *
 */

public class CLUI {
	
	public static void main(String[] args) {
		
		/**
		 * Scanner to read user input
		 */
		Scanner scanner = new Scanner(System.in);
		
		
		String commandline = "";

		String[] initialisation = {"ini","C:\\Users\\axel\\eclipse-workspace\\myUber2\\ini.ini"};
		Clui(initialisation);
		while(!commandline.equalsIgnoreCase("stop")) {
			
		System.out.println("write something");
		commandline = scanner.nextLine();	
		System.out.println(commandline.toString());
		String[] parsedCommandline = commandline.split(" "); //separate command arguments
		Clui(parsedCommandline);
		}}
		
		public static void Clui(String[] parsedCommandline){
		/**
		 * instantiate object from MyUber class
		 */
		MyUber clientApp = new MyUber();

		//communicates with client app to setup an environment 
		if (parsedCommandline[0].equals("setup") && parsedCommandline.length == 5){

			try {
				int nStandardCar = Integer.parseInt(parsedCommandline[1]);
				int nBerlineCar = Integer.parseInt(parsedCommandline[2]);
				int nVanCar = Integer.parseInt(parsedCommandline[3]);
				int nCustomer = Integer.parseInt(parsedCommandline[4]);
				clientApp.setup(nStandardCar, nBerlineCar, nVanCar, nCustomer);
				
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}

		
		//communicates with client app to add a Customer 
		if (parsedCommandline[0].equals("addCustomer") && parsedCommandline.length == 3){
				String name = parsedCommandline[1];
				String surname = parsedCommandline[2];
			try {
				clientApp.addCustomer(name,surname);
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		
		//communicates with client app to setup an add a Driver and its Car 
		if (parsedCommandline[0].equals("addCarDriver") && parsedCommandline.length == 4){
				String Drivername = parsedCommandline[1];
				String Driversurname = parsedCommandline[2];
				String carType = parsedCommandline[3];
			try {
				clientApp.addCarDriver(Drivername, Driversurname,carType);
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		
		//communicates with client app to setup an add a Driver and relate it to a Car
		if (parsedCommandline[0].equals("addDriver") && parsedCommandline.length == 4){
				String Drivername = parsedCommandline[1];
				String Driversurname = parsedCommandline[2];
				String carID = parsedCommandline[3];
			try {
				clientApp.addDriver(Drivername, Driversurname,carID);
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		
		
		//communicates with client app to setup an add a Driver and its Car 
		if (parsedCommandline[0].equals("setDriverStatus") && parsedCommandline.length == 4){
				String Drivername = parsedCommandline[1];
				String Driversurname = parsedCommandline[2];
				String status = parsedCommandline[3];
			try {
				clientApp.setDriverStatus(Drivername, Driversurname,status);		
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		
		//communicates with client app to move the car
		if (parsedCommandline[0].equals("moveCar") && parsedCommandline.length == 4){
			String carId = parsedCommandline[1];
			System.out.println(carId);
			try {
				double posX = Float.parseFloat(parsedCommandline[2]);
				double posY = Float.parseFloat(parsedCommandline[3]);
				GPSPosition gpsPosition = new GPSPosition(posX,posY);
				if(clientApp.moveCar(carId, gpsPosition)){System.out.println("Car succesfully moved");}
				else{System.out.println("an error occured, check the input");}
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		
		//communicates with client app to move the customer
		if (parsedCommandline[0].equals("moveCustomer") && parsedCommandline.length == 4){
			String customerId = parsedCommandline[1];
			try {
				double posX = Float.parseFloat(parsedCommandline[2]);
				double posY = Float.parseFloat(parsedCommandline[3]);
				GPSPosition gpsPosition = new GPSPosition(posX,posY);
				if(clientApp.moveCustomer(customerId, gpsPosition)){
					System.out.println("Customer succesfully moved");}
				else{System.out.println("an error occured, check the input");}
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		
		//communicates with client app to display the state
		if (parsedCommandline[0].equals("displayState") && parsedCommandline.length == 1){
			try {
				clientApp.displayState();	
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		
		//communicates with client app to get the list of prices
		if (parsedCommandline[0].equals("moveCustomer") && parsedCommandline.length == 4){
			String customerId = parsedCommandline[1];
			try {
				double posX = Float.parseFloat(parsedCommandline[2]);
				double posY = Float.parseFloat(parsedCommandline[3]);
				GPSPosition gpsPosition = new GPSPosition(posX,posY);
				if(clientApp.moveCustomer(customerId, gpsPosition)){
					System.out.println("Customer succesfully moved");}
				else{System.out.println("an error occured, check the input");}
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}

	}
	

}
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
		
		/**
		 * instantiate object from MyUber class
		 */
		MyUber clientApp = new MyUber();
		
		/*boolean exit = false;
		String command = "";
		ArrayList <String> arguments = new ArrayList<String>();
		boolean readFromFile = false;
		ArrayList<String> commandsList= new ArrayList<String>();*/
		System.out.println("write smthng");
		String commandline = scanner.nextLine();	
		System.out.println(commandline.toString());
		String[] parsedCommandline = commandline.split(" "); //separate command arguments
		System.out.println("test1");
		System.out.println(parsedCommandline[0].equals("moveCar"));
		
		//communicates with client app to setup an environment 
		if (parsedCommandline[0].equals("setup") && parsedCommandline.length == 5){
			System.out.println("test2");

			try {
				int nStandardCar = Integer.parseInt(parsedCommandline[1]);
				int nBerlineCar = Integer.parseInt(parsedCommandline[2]);
				int nVanCar = Integer.parseInt(parsedCommandline[3]);
				int nCustomer = Integer.parseInt(parsedCommandline[4]);
				if(clientApp.setup(nBerlineCar, nVanCar, nCustomer)){System.out.println("System setup");}
				else{System.out.println("an error occured, check the input");}
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		System.out.println("test3");
	
		//communicates with client app to add a Customer 
		if (parsedCommandline[0].equals("addCustomer") && parsedCommandline.length == 3){
			System.out.println("test2");
				String name = parsedCommandline[1];
				String surname = parsedCommandline[2];
			try {
				clientApp.addCustomer(name,surname);
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		System.out.println("test3");
		
		//communicates with client app to setup an add a Driver and its Car 
		if (parsedCommandline[0].equals("addCarDriver") && parsedCommandline.length == 4){
			System.out.println("test2");
				String Drivername = parsedCommandline[1];
				String Driversurname = parsedCommandline[2];
				String carType = parsedCommandline[3];
			try {
				clientApp.addCarDriver(Drivername, Driversurname,carType);
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		System.out.println("test3");
		
		//communicates with client app to setup an add a Driver and relate it to a Car
		if (parsedCommandline[0].equals("addDriver") && parsedCommandline.length == 4){
			System.out.println("test2");
				String Drivername = parsedCommandline[1];
				String Driversurname = parsedCommandline[2];
				String carID = parsedCommandline[3];
			try {
				clientApp.addDriver(Drivername, Driversurname,carID);
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		System.out.println("test3");
		
		
		//communicates with client app to setup an add a Driver and its Car 
		if (parsedCommandline[0].equals("setDriverStatus") && parsedCommandline.length == 4){
			System.out.println("test2");
				String Drivername = parsedCommandline[1];
				String Driversurname = parsedCommandline[2];
				String status = parsedCommandline[3];
			try {
				clientApp.setDriverStatus(Drivername, Driversurname,status);		
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		System.out.println("test3");
		
		//communicates with client app to move the car
		if (parsedCommandline[0].equals("moveCar") && parsedCommandline.length == 4){
			System.out.println("test2");
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
		System.out.println("test3");
		
	}
	

}

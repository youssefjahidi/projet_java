package myUber;

import java.util.ArrayList;
import java.util.Scanner;


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
		//communicates with client app to move the car
		if (parsedCommandline[0].equals("moveCar") && parsedCommandline.length == 4){
			System.out.println("test2");
			String carId = parsedCommandline[1];
			System.out.println(carId);
			try {
				float posX = Float.parseFloat(parsedCommandline[2]);
				float posY = Float.parseFloat(parsedCommandline[3]);
				if(clientApp.moveCar(carId, posX, posY)){System.out.println("Car succesfully moved");}
				else{System.out.println("an error occured, check the input");}
					
			} catch (Exception e) {
				System.out.println("an error occured, check the input");
			}

		}
		System.out.println("test3");
		
	}
	

}

package myUber;

import java.util.Date;

import Car.Berline;
import Car.CarFactory;
import Car.Standard;
import Car.*;
import Rides.Rides;
import Users.Customer.*;
import Users.Driver.*;

public class runTest {

	public static void main(String[] args) {
		Van.initializeList();
		Berline.initializeList();
		Standard.initializeList();
		
		Customer C1 = new Customer("Pierre","P","48°52'50\", 0°0'0\"",12);
		
		Driver D1 = new Driver("jean", "J");
		Driver D2 = new Driver("michel","M");
		
		Car V = CarFactory.createCar("Berline");
		V.create("48°50'20\", 0°0'0\"");
		V.addDriver(D1); V.addDriver(D2);
		
		
		D1.setonduty();
		
		//Driver t = V.contact("",0,0) ;
		C1.request("48°52'50\", 0°4'54\"");
		C1.choose();
		System.out.println(Rides.BookOfRides.get(0));
	}

}

package myUber;

public class runTest {

	public static void main(String[] args) {
		Van.initializeList();
		Berline.initializeList();
		Standard.initializeList();
		
		
		Driver D1 = new Driver("jean", "J");
		Driver D2 = new Driver("michel","M");
		
		Car V = CarFactory.createCar("Berline");
		V.create("earth");
		V.addDriver(D1); V.addDriver(D2);
		
		
		D1.setonduty();
		//boolean t = V.contact() ;
		System.out.println(V.getID() + V.getGPS() + " "  + "\n" );
	}

}

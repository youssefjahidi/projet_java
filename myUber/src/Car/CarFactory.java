package Car;

import myUber.*;

public class CarFactory {
	
	public static Car createCar(String CarType) {
		if(CarType == null) {return null;}
		if(CarType.equalsIgnoreCase("Standard")) {
			return new Standard();
		}
		if(CarType.equalsIgnoreCase("Berline")) {
			return new Berline();
		}
		if(CarType.equalsIgnoreCase("Van")) {
			return new Van();
		}
		return null;
	}
}

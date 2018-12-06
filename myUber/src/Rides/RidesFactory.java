package Rides;

public class RidesFactory {

	public static Rides createRides(String RidesType) {
		if(RidesType == null) {return null;}
		if(RidesType.equalsIgnoreCase("UberX")) {
			return new UberX();
		}
		if(RidesType.equalsIgnoreCase("UberVan")) {
			return new UberVan();
		}
		if(RidesType.equalsIgnoreCase("UberPool")) {
			return new UberPool();
		}
		if(RidesType.equalsIgnoreCase("UberBlack")) {
			return new UberBlack();
		}
		return null;
	}
}
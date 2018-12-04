package Rides;

import Users.Customer;
import myUber.GPSPosition;

public class RidesFactory {
	
	private static int uberXIdAct;
	private static int uberBlackIdAct;
	private static int uberVanIdAct;
	private static int uberPoolIdAct;
	
	public RidesFactory(){
		this.uberXIdAct = 0;
		this.uberBlackIdAct = 0;
		this.uberVanIdAct = 0;
		this.uberPoolIdAct = 0;
	}
	
	
	// A COMPLETER

	public static Rides createRides(Customer customer, GPSPosition destination, RideType rideType) {
		if(rideType.equals(RideType.uberX)) {
			uberXIdAct++;
			return new UberX(customer, destination, uberXIdAct);
		}
		/*else if(rideType.equals(RideType.uberBlack)) {
			uberBlackIdAct++;
			return new UberBlack(customer, destination, uberBlackIdAct);
		}*/
		/*if(rideType.equals(RideType.uberVan)) {
			uberVanIdAct++;
			return new UberVan(customer, destination, uberVanIdAct);
		}*/
		/*if(rideType.equals(RideType.uberX)) {
			uberXIdAct++;
			return new UberX(customer, destination, uberXIdAct);
		}*/
		/*else (rideType.equals(RideType.uberX)) {
			uberXIdAct++;
			return new UberX(customer, destination, uberXIdAct);
		}*/
		else{return null;}
	}
}

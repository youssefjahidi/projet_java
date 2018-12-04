package Car;
/**
 * This class is a car factory. Keeps track of the id counter for each type of cars and instantiate
 * cars.
 * 
 * @author Youssef Jahidi
 * 
 * @author Axel Vincent
 */


public class CarFactory {
	/**
	 * id counter for standard cars
	 */
	private int standardIdAct;
	
	/**
	 * id counter for berlines
	 */
	private int berlineIdAct;
	
	/**
	 * id counter for van
	 */
	private int vanIdAct;
	
	
	/**
	 * instntiate a factory by setting the counters to 0.
	 */
	public CarFactory() {
		 this.standardIdAct = 0;
		 this.berlineIdAct = 0;
		 this.vanIdAct = 0;
	}


	/**
	 *  car creation methods
	 * @param CarType Can be standard, berline or van
	 * @return a car object
	 */
	public Car createCar(String CarType) {
		if(CarType == null) {return null;}
		if(CarType.equalsIgnoreCase("Standard")) {
			standardIdAct++;
			return new Standard(standardIdAct);			
		}
		if(CarType.equalsIgnoreCase("Berline")) {
			berlineIdAct++;
			return new Berline(berlineIdAct);
		}
		if(CarType.equalsIgnoreCase("Van")) {
			vanIdAct++;
			return new Van(vanIdAct);
		}
		return null;
	}
}

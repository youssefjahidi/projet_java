package Car;


public class CarFactory {
	
	private static int standardIdAct;
	private static int berlineIdAct;
	private static int vanIdAct;
	
	
	
	public CarFactory() {
		 this.standardIdAct = 0;
		 this.berlineIdAct = 0;
		 this.vanIdAct = 0;
	}



	public static Car createCar(String CarType) {
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

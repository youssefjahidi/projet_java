package myUber;
import java.util.ArrayList;
import java.util.HashMap;

import Car.*;
import Rides.*;
import Users.*;

/**
 * Client app
 * @author Youssef
 *
 */

public class MyUber {
	
	//public static ArrayList<Standard> S_exist = new ArrayList<Standard>();
	
	/*public  Driver contact(String nom, double distchauff,double length){
		for(Driver driver: drivers){
			if(driver.getState().equals("onduty")){
				if(driver.contact(nom, distchauff, length)) {return driver;}
			}
		}
		return null;
	};*/
	
	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Standard> standardCars = new HashMap<String, Standard>();
	
	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Berline> berlineCars = new HashMap<String, Berline>();
	
	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Van> vanCars = new HashMap<String, Van>();
	
	/**
	 * Cars hashmap indexed by car id
	 */
	public static HashMap<String, Car> allCars = new HashMap<String, Car>();
	
	/**
	 * Change car's gps position
	 * @param carId car id 
	 * @param posX x coordinate
	 * @param posY y coordinate
	 * @return Boolean: true if id found and coordinates inside the bounds, else returns false.
	 */
	public boolean moveCar(String carId, float posX, float posY){
		allCars.putAll(standardCars);
		allCars.putAll(berlineCars);
		allCars.putAll(vanCars);		
		if(allCars.containsKey(carId) && Math.abs(posX)<=50 && Math.abs(posY)<=50 ){
			allCars.get(carId).setGpsPositionX(posX);
			allCars.get(carId).setGpsPositionY(posY);
			return true;}
		else{return false;}
	}

}

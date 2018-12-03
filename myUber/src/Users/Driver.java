package Users;

import java.util.Scanner;
/**
 * This class represents a car driver
 * @author Youssef Jahidi
 * 
 * @autot Axel Vincent
 *
 */
public class Driver extends User{
	private DriverState state;
	private static int idact;
	
	
	Driver(String name, String surname){
		super(name, surname, Driver.idact);
		this.state = DriverState.offline;
		Driver.idact ++;
	}


	/**
	 * @return the state
	 */
	public DriverState getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(DriverState state) {
		this.state = state;
	}


	/**
	 * @return the idact
	 */
	public static int getIdact() {
		return idact;
	}
	
	
	
}

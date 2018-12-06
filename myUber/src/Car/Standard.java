package Car;
import java.util.ArrayList;

import Users.Driver;

/**
 * This class represents a standard car. It can carry up to 4 passengers
 *
 * @author Youssef Jahidi
 * 
 * @author Axel Vincent
 */

public class Standard extends Car {	
	/**
	 * Constructor of a standard car, gives it an ID.
	 * @param idAct Active counter to avoid giving different cars the same id
	 */
	public Standard(int idAct) {
		super(4, "Standard" + (String) Integer.toString(idAct));
	}

}
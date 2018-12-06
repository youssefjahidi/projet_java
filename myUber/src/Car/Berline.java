package Car;
import java.util.ArrayList;

import Users.Driver;
/**
 * This class represents a berline. It can carry up to 4 passengers
 *
 * @author Youssef Jahidi
 * 
 * @author Axel Vincent
 */
public class Berline extends Car {
	/**
	 * Constructor of a berline, gives it an ID.
	 * @param idAct Active counter to avoid giving different cars the same id
	 */
	public Berline(int idAct) {
		super(4, "Berline" + (String) Integer.toString(idAct));
	}
	
	
}
package Car;
import java.util.ArrayList;

import Users.Driver;
/**
 * This class represents a van. It can carry up to 6 passengers
 *
 * @author Youssef Jahidi
 * 
 * @author Axel Vincent
 */
public class Van extends Car {
	/**
	 * Constructor of a van, gives it an ID.
	 * @param idAct Active counter to avoid giving different cars the same id
	 */
	public Van(int idAct) {
		super(6, "Van" + (String) Integer.toString(idAct));
	}

}
package Car;
import java.util.ArrayList;

import Users.Driver;

public class Van extends Car {
	
	public Van(int idAct) {
		super(6, "Van" + (String) Integer.toString(idAct));
	}

}

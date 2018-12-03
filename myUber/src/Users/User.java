package Users;
import java.util.HashMap;

import Rides.*;
/**
 *  The User class is a superclass that groups both the drivers ans the customers.
 *  
 * @author Youssef Jahidi
 *
 */
public class User {
	/**
	 * name of the user
	 */
	private String name;
	
	/**
	 * surname of the user
	 */
	private String surname;
	
	/**
	 * user id
	 */
	private int id;
	
	/**
	 * hashmap that stores the previous rides of the user, indexed by ride id
	 */
	private HashMap<Integer, Rides> userRides;
	
	/**
	 * user rating
	 */
	private float rating;
	
	/**
	 * user number of rides
	 */
	private int nbRides;
	
	
	/**
	 * Constructor of the User class
	 * @param name name of the user
	 * @param surname surname of the user
	 */
	public User(String name, String surname, int id){
		this.name = name;
		this.surname = surname;
		this.id = id;}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}


	/**
	 * @return the userRides
	 */
	public HashMap<Integer, Rides> getUserRides() {
		return userRides;
	}

	/**
	 * @param userRides the userRides to set
	 */
	public void setUserRides(HashMap<Integer, Rides> userRides) {
		this.userRides = userRides;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	/**
	 * @return the nbRides
	 */
	public int getNbRides() {
		return nbRides;
	}

	/**
	 * @param nbRides the nbRides to set
	 */
	public void setNbRides(int nbRides) {
		this.nbRides = nbRides;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	

}

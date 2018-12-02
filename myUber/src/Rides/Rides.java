package Rides;

import java.util.ArrayList;

import Users.Customer;
import myUber.UberVisitor;

public interface Rides {
	public static ArrayList<String> BookOfRides = new ArrayList<String>();

	
	public String getdestination();
	public Customer getcustomer();
	public double getlength();
	
	
	public void setunconfirmed();
	public void setconfirmed();
	public void setongoing();
	public void setcanceled();
	public void setcompleted();
	
	public void request();
	public void cancel();
	public void note(int note);
	
	public double accept(UberVisitor visitor);
	public void prepare(Customer customer, String destination, int nbpersonne);

}

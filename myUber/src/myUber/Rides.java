package myUber;

public interface Rides {
	
	public String getdestination();
	public Customer getcustomer();
	public double getlength();
	public String gettime();
	
	
	public void setunconfirmed();
	public void setconfirmed();
	public void setongoing();
	public void setcanceled();
	public void setcompleted();
	
	public void request();

	
	public double accept(UberVisitor visitor);
	public void prepare(Customer customer, String destination, int nbpersonne, String time);

}

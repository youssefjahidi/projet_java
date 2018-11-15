package myUber;
public interface Car {


	public  void addDriver(Driver driver);
	public  boolean contact();
	
	public String getID();
	public int getnbplace();
	public String getGPS();
	
	void create(String GPS);

}


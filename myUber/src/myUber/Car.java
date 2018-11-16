package myUber;
public interface Car {


	public  void addDriver(Driver driver);
	public  Driver contact(String nom, double distchauff,double length);
	
	public String getID();
	public int getnbplace();
	public String getGPS();
	
	void create(String GPS);

}

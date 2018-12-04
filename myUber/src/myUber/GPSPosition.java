package myUber;

public class GPSPosition {
	
	private double Xpos;
	private double Ypos;
	public GPSPosition(double Xpos, double Ypos) {
		this.Xpos = Xpos;
		this.Ypos = Ypos;
	}
	
	public double getX() {
		return this.Xpos;
	}	
	public double getY() {
		return this.Ypos;
	}
	public void setX(double Xpos) {
		this.Xpos = Xpos;
	}
	public void setY(double Ypos) {
		this.Xpos = Ypos;
	}
	
	public double distance(GPSPosition GPS) {
		return Math.sqrt(   Math.pow( this.getX()-GPS.getX(),2 ) + 
				Math.pow( this.getY()-GPS.getY(),2)   );
	}
	
	public void equal() {
		
	}

}

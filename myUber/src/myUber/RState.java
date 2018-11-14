package myUber;

public class RState {
	private String state;
	public void setState(String state) {
		if(state == "unconfirmed" || state =="confirmed" 
				||state == "ongoing" || state =="canceled" 
				||state == "completed") {
			this.state = state;
		}
	}
	public String getState() {
		return this.state;
	}

}

package myUber;

public class DState {
	String state;
	public void setstate(String state) {
		if (state == "a" || state =="b" ||state == "c")
			this.state= state;
	}
	public String getState() {
		return this.state;
	}
}

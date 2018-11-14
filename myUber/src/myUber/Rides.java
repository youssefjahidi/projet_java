package myUber;

public class Rides {
	private Customer customer;
	private String destination;
	private RState state;
	
	Rides(Customer customer, String destination){
		this.customer = customer;
		this.destination = destination;
		this.state = new RState();
		this.state.setState("unconfirmed");
	}

}

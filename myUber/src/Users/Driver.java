package Users;

import java.util.Scanner;

import Car.Car;
/**
 * This class represents a car driver
 * @author Youssef Jahidi
 * 
 * @autot Axel Vincent
 *
 */
public class Driver extends User{
	private Car car;
	private DriverState state;
	private static int idact;
	private double totalMoney;
	private float onDutyRate;
	private float activityRate;
	
	
	public Driver(String name, String surname){
		super(name, surname, Driver.idact);
		this.state = DriverState.offline;
		Driver.idact ++;
	}


	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}


	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}


	/**
	 * @return the state
	 */
	public DriverState getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(DriverState state) {
		this.state = state;
	}


	/**
	 * @return the totalMoney
	 */
	public double getTotalMoney() { // implement that
		return totalMoney;
	}


	/**
	 * @param totalMoney the totalMoney to set
	 */
	public void addMoney(double Money) {
		this.totalMoney = this.totalMoney + Money;
	}


	/**
	 * @return the onDutyRate
	 */
	public float getOnDutyRate() { //implement this
		return onDutyRate;
	}


	/**
	 * @param onDutyRate the onDutyRate to set
	 */
	public void setOnDutyRate(float onDutyRate) {
		this.onDutyRate = onDutyRate;
	}


	/**
	 * @return the activityRate
	 */
	public float getActivityRate() { // implement this
		return activityRate;
	}


	/**
	 * @param activityRate the activityRate to set
	 */
	public void setActivityRate(float activityRate) {
		this.activityRate = activityRate;
	}


	/**
	 * @return the idact
	 */
	public static int getIdact() {
		return idact;
	}



	
	
	
}
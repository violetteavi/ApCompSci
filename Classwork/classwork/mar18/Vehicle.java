package mar18;

public class Vehicle {
	
	private String name;

	public Vehicle(String name) {
		this.name = name;
	}
	
	private int milesDriven = 0;
	private int passengers;
	
	public String getType() {
		String[] noClass = this.getClass().toString().split(" ");
		String[] noPackage = noClass[noClass.length - 1].split("\\.");
		return noPackage[noPackage.length - 1];
	}
	
	public void drive(int miles) {
		milesDriven += miles;
	}
	
	public int getMilesDriven() {
		return milesDriven;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getPassengers() {
		return passengers;
	}
}

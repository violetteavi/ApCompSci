package mar18;

public class Vehicle {
	
	private int milesDriven = 0;
	private int passengers;
	
	public String getType() {
		return this.getClass().toString();
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

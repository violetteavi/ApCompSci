package mar18;

public class Truck extends Vehicle{

	public Truck(String name) {
		super(name);
	}

	private int towLimit;

	public void setTowLimit(int towLimit) {
		this.towLimit = towLimit;
	}

	public int getTowLimit() {
		return towLimit;
	}
}

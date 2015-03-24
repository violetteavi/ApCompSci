package mar24;

public class Bird extends Animal {
	
	protected boolean happy;
	
	public void fly()
	{
		System.out.println("The bird flies");
		happy = true;
	}
	
	public void swim() {
		System.out.println("The bird cannot swim");
		happy = false;
	}

	public void layEgg()
	{
		System.out.println("The bird layed an egg.");
	}

	public void doStuff()
	{
		System.out.println("Doing some stuff...");
		fly(); layEgg();
	}

	public boolean isHappy() {
		return happy;
	}

}

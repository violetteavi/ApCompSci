package mar24;

public class Penguin extends Bird {

	public void fly() {
		System.out.println("The penguin cannot fly.");
		happy = false;
	}

	public void swim() {
		System.out.println("The penguin is swimming.");
		happy = true;
	}
	
	public void doStuff() {
		super.doStuff();
		swim();
	}
}

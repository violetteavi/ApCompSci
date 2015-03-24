package mar24;

public class Animal {

	public void eat() {
		System.out.println("The " + this.getType().toLowerCase() + " is eating.");
	}	
	
	public String getType() {
		String[] noClass = this.getClass().toString().split(" ");
		String[] noPackage = noClass[noClass.length - 1].split("\\.");
		return noPackage[noPackage.length - 1];
	}
}

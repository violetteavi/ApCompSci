package mar25;

public class LoudDog extends Dog{

	public LoudDog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String speak() {
		return super.speak() + super.speak();
	}

}

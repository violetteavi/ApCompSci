package mar25;

public class Cat extends Pet {

	public Cat(String name) {
		super(name);
	}

	@Override
	String speak() {
		return "meow";
	}

}

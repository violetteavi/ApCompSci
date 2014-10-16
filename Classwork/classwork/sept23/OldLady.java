package sept23;

public class OldLady {

	public static void main(String[] args) {
		swallow("fly");
		chainFly();
		swallow("spider");
		chainSpider();
		swallow("bird");
		startBird();
		swallow("cat");
		startCat();
		swallow("dog");
		startDog();
		swallow("goat");
		startGoat();
		swallow("cow");
		startCow();
		swallow("horse");
		startHorse();
	}
	
	public static void swallow(String notFood) {
		System.out.println("I know an old lady who swallowed a " + notFood + ",");
	}
	
	public static void chainFly() {
		System.out.println("I don't know why she swallowed the fly,");
		System.out.println("I guess she'll die.");
		System.out.println();
	}
	
	public static void chainSpider() {
		System.out.println("That wriggled and jiggled and tickled inside her,");
		System.out.println("She swallowed the spider to catch the fly,");
		chainFly();
	}
	
	public static void chainBird() {
		System.out.println("She swallowed the bird to catch the spider,");
		chainSpider();
	}
	
	public static void chainCat() {
		System.out.println("She swallowed the cat to catch the bird,");
		chainBird();
	}
	
	public static void chainDog() {
		System.out.println("She swallowed the dog to catch the cat,");
		chainCat();
	}
	
	public static void chainGoat() {
		System.out.println("She swallowed the goat to catch the dog,");
		chainDog();
	}
	
	public static void chainCow() {
		System.out.println("She swallowed the cow to catch the goat,");
		chainGoat();
	}
	
	public static void startBird() {
		System.out.println("How absurd to swallow a bird!");
		chainBird();
	}
	
	public static void startCat() {
		System.out.println("Imagine that, to swallow a cat!");
		chainCat();
	}
	
	public static void startDog() {
		System.out.println("My, what a hog, to swallow a dog!");
		chainDog();
	}
	
	public static void startGoat() {
		System.out.println("Just opened her throat and swallowed a goat!");
		chainGoat();
	}
	
	public static void startCow() {
		System.out.println("I wonder how she swallowed a cow?!");
		chainCow();
	}
	
	public static void startHorse() {
		System.out.println("She's dead, of course!!");
	}
}

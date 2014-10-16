package sept22;

public class PicturesInPrint {

	public static void main(String[] args){
		printEgg();
		System.out.println();
		printCupAndSaucer();
		System.out.println();
		printStopSign();
		System.out.println();
		printHat();
	}

	private static void printEgg() {
		printTop();
		printBottom();
	}

	private static void printCupAndSaucer() {
		printBottom();
		printLine();   
	}

	private static void printStopSign() {
		printTop();
		printStop();
		printBottom();
	}

	private static void printHat() {
		printTop();
		printLine();
	}
	
	
	private static void printLine() {
		System.out.println("+--------+");
	}

	private static void printStop() {
		System.out.println("|  STOP  |");
	}

	private static void printBottom() {
		System.out.println("\\        /");
		System.out.println(" \\______/");
	}

	private static void printTop() {
		System.out.println("  ______");
		System.out.println(" /      \\");
		System.out.println("/        \\");
	}
}

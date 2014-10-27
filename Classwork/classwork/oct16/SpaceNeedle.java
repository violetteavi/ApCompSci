package oct16;

public class SpaceNeedle {

	public static final int SIZE = 10;
	public static void main(String[] args) {
		printTip();
		printCap();
		printLine();
		printBottom();
		printTip();
		printSpine();
		printCap();
		printLine();
	}
	
	public static void printTip() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				System.out.print("   ");
			}
			System.out.println("||");
		}
	}
	
	public static void printCap() {
		for(int i = SIZE - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print("   ");
			}
			System.out.print("__/");
			for(int h = SIZE - 1 - i; h > 0; h--) {
				System.out.print(":::");
			}
			System.out.print("||");
			for(int h = SIZE - 1 - i; h > 0; h--) {
				System.out.print(":::");
			}
			System.out.println("\\__");
		}
	}
	
	public static void printLine() {
		System.out.print("|");
		for(int i = 0; i < SIZE * 6; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
	}
	
	public static void printBottom() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.print("\\_");
			for(int h = SIZE * 3 - 1 - 2 * i; h > 0; h--) {
				System.out.print("/\\");
			}
			System.out.println("_/");
		}
	}
	
	public static void printSpine() {
		for(int i = 0; i < SIZE * SIZE; i++) {
			for(int j = 0; j < SIZE * 2 + 1; j++) {
				System.out.print(" ");
			}
			System.out.print("|");
			for(int j = 0; j < SIZE - 2; j++) {
				System.out.print("%");
			}
			System.out.print("||");
			for(int j = 0; j < SIZE - 2; j++) {
				System.out.print("%");
			}
			System.out.println("|");
		}
	}
}

package oct16;

public class SpaceNeedle {

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
		for(int i = 0; i < 4; i++) {
			System.out.println("            ||");
		}
	}
	
	public static void printCap() {
		for(int i = 3; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print("   ");
			}
			System.out.print("__/");
			for(int h = 3 - i; h > 0; h--) {
				System.out.print(":::");
			}
			System.out.print("||");
			for(int h = 3 - i; h > 0; h--) {
				System.out.print(":::");
			}
			System.out.println("\\__");
		}
	}
	
	public static void printLine() {
		System.out.print("|");
		for(int i = 0; i < 24; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
	}
	
	public static void printBottom() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.print("\\_");
			for(int h = 11 - 2 * i; h > 0; h--) {
				System.out.print("/\\");
			}
			System.out.println("_/");
		}
	}
	
	public static void printSpine() {
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(" ");
			}
			System.out.println("|%%||%%|");
		}
	}
}

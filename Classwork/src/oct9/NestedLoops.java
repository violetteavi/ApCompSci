package oct9;

public class NestedLoops {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(i + 1);
			}
			System.out.println();
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print(i + 1);
			}
			System.out.println();
		}
		
		for(int i = 5; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}

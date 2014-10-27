package oct22;

public class ArgumentsGalore {

	public static void main(String args[]) {
		rectStars(3, 5);
		perfectSquares(5);
	}

	private static void perfectSquares(int n) {
		for(int i = 1; i <= n; i++) {
			System.out.println(i * i);
		}
	}

	private static void rectStars(int x, int y) {
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public String interleave(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}

package elvens;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		for(int i = 0; i < values.length/2; i++) {
			shuffled[1 + 2*i] = values[i];
		}
		for(int i = values.length/2; i < values.length; i++) {
			shuffled[2*(i-values.length/2)] = values[i];
		}
		for(int i = 0; i < values.length; i++) {
			values[i] = shuffled[i];
		}
	}

	public static void selectionShuffle(int[] values) {
		for(int i = values.length-1; i>=0; i--) {
			int toSwap = (int) (Math.random() * (i + 1));
			int temp = values[i];
			values[i] = values[toSwap];
			values[toSwap] = temp;
		}
	}
}

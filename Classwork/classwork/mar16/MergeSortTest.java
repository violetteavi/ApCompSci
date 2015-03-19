package mar16;

import static org.junit.Assert.*;

import org.junit.Test;


public class MergeSortTest {

	@Test
	public void mergeTest() {
		int[] input1 = {1, 4, 5, 9, 12, 0, 0, 0, 0, 0};
		int[] input2 = {0, 0, 0, 0, 0, 2, 3, 7, 11, 15};
		int[] expectedOutput = {1, 2, 3, 4, 5, 7, 9, 11, 12, 15};
		int[] sorted = new int[10];
		MergeSort.merge(input1, 0, 4, input2, 5, 9, sorted);
		for(int i = 0; i < expectedOutput.length; i++) {
			assertEquals(expectedOutput[i], sorted[i]);
		}
	}
}

package feb12;

import java.util.Arrays;

public class SortingAlgorithms {
	
	public static void main(String[] args) {
		int[] test = {7,3,2,5,4,7,8,9,2};
		System.out.println(Arrays.toString(test));
//		selectionSort(test);
//		System.out.println(Arrays.toString(test));
		insertionSort(test);
		System.out.println(Arrays.toString(test));
	}
	
	public static void selectionSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int relMin = nums[i];
			int relMinIndex = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[relMinIndex]) {
					relMinIndex = j;
				}
			}
			swap(i, relMinIndex, nums);
		}
	}

	private static void swap(int ind1, int ind2, int[] nums) {
		int temp = nums[ind1];
		nums[ind1] = nums[ind2];
		nums[ind2] = temp;
	}
	
	private static void insertionSort(int[] nums) {
		for(int i  = 1; i < nums.length; i++) {
			for(int j = i; j > 0; j--) {
				if(nums[j] < nums[j - 1]) {
					swap(j, j - 1, nums);
				}
			}
		}
	}

}

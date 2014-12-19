package practiceit;

public class PracticeIt {

	
	public static boolean isMagicSquare(int[][] nums) {
		for(int i = 0; i < nums.length; i++) {
		    if(nums.length!=nums[i].length) {
		        return false;
		    }			
		}
		
	    int magicNumber = 0;
	    for(int i = 0; i < nums.length; i++) {
	        magicNumber+= nums[0][i];
	    }
	    
	    for(int i = 0; i < nums.length; i++) {
	        int sumOfRow = 0;
	        for(int j = 0; j < nums.length; j++) {
	            sumOfRow += nums[i][j];
	        }
	        if(sumOfRow!=magicNumber) {
	            return false;
	        }
	    }
	    
	    for(int i = 0; i < nums.length; i++) {
	        int sumOfColumn = 0;
	        for(int j = 0; j < nums.length; j++) {
	            sumOfColumn += nums[j][i];
	        }
	        if(sumOfColumn!=magicNumber) {
	            return false;
	        }
	    }
	    
	    int sumOfDiagonal = 0;
	    for(int i = 0; i < nums.length; i++) {
	        sumOfDiagonal+= nums[i][i];
	    }
	    if(sumOfDiagonal!=magicNumber) {
	        return false;
	    }
	    
	    sumOfDiagonal = 0;
	    for(int i = nums.length; i < 0; i--) {
	        sumOfDiagonal+= nums[i-1][i-1];
	    }
	    if(sumOfDiagonal!=magicNumber) {
	        return false;
	    }
	    return true;
	}
}

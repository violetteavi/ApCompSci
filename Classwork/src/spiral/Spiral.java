package spiral;

public class Spiral {

	static Spiral aSpiral;
	
	public static void main(String[] args) {
		aSpiral = new Spiral();
		aSpiral.print(aSpiral.spiral(5, 5));
	}
	public boolean isEqual(int[][] expected, int[][] actual) {
		if(expected==null||actual==null) {
			if(expected==null&&actual==null) {
				return true;
			}
			return false;
		}
		if(expected.length!=actual.length||expected[0].length!=actual[0].length){
			return false;
		}
		for(int y = 0; y < actual.length; y++){
			for(int x = 0; x < actual[y].length; x++){
				if(actual[y][x]!=expected[y][x]) {
					return false;
				}				
			}
			
		}
		return true;
	}

	/**
	 * Returns a 2D array of ints of length x and height y that spiral 1 through x * y inward.
	 */
	public int[][] spiral(int x, int y) {
		int[][] toReturn = new int[y][x];
		int blockedDirections = 0;
		int currentX = 0;
		int currentY = 0;
		int slotCounter = 1;
		toReturn[currentX][currentY] = slotCounter; // the loop moves, then assigns, so the starting block must be initialized
		while(blockedDirections < 4) {
			//move right
			if(currentX + 1 < toReturn[currentY].length && toReturn[currentY][currentX + 1] == 0) {
				blockedDirections = 0;
				while(currentX + 1 < toReturn[currentY].length && toReturn[currentY][currentX + 1] == 0) {
					currentX++;
					slotCounter++;
					toReturn[currentY][currentX] = slotCounter;
				}
			} else {
				blockedDirections++;
			}
			
			//move down
			if(currentY + 1 < toReturn.length && toReturn[currentY + 1][currentX] == 0) {
				blockedDirections = 0;
				while(currentY + 1 < toReturn.length && toReturn[currentY + 1][currentX] == 0) {
					currentY++;
					slotCounter++;
					toReturn[currentY][currentX] = slotCounter;
				}
			} else {
				blockedDirections++;
			}

			//move left
			if(currentX > 0 && toReturn[currentY][currentX - 1] == 0) {
				blockedDirections = 0;
				while(currentX > 0 && toReturn[currentY][currentX - 1] == 0) {
					currentX--;
					slotCounter++;
					toReturn[currentY][currentX] = slotCounter;
				}
			} else {
				blockedDirections++;
			}
			
			//move down
			if(currentY > 0 && toReturn[currentY - 1][currentX] == 0) {
				blockedDirections = 0;
				while(currentY > 0 && toReturn[currentY - 1][currentX] == 0) {
					currentY--;
					slotCounter++;
					toReturn[currentY][currentX] = slotCounter;
				}
			} else {
				blockedDirections++;
			}
		}
		return toReturn;
	}
	
	public void print(int[][] toPrint) {
		for(int[] y: toPrint) {
			for(int x: y) {
				System.out.print(x + ", ");
			}
			System.out.println();
		}
	}

}

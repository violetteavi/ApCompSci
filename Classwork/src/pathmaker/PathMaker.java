package pathmaker;

public class PathMaker {

	public int numPaths(int x, int y) {
		int[][] paths = new int[y + 1][x + 1];
		paths[0][0] = 1;
		for(int distance = 1; distance <= x + y; distance++) {
			for(int i = 0; i <= distance; i++) {
				if(distance - i <= y && i <= x) {
					int pathsUp = 0;
					int pathsLeft = 0;
					if(distance!=i) {
						pathsUp = paths[distance - i - 1][i];
					}
					if(i!=0) {
						pathsLeft = paths[distance - i][i - 1];
					}
					paths[distance - i][i] = pathsUp + pathsLeft;
				}
			}
		}
		return paths[y][x];
	}
	
	public int sumDigits(int num) {
		int sum = 0;
		while(num!=0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

}

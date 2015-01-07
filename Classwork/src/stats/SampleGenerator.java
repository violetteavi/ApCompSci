package stats;

import java.util.Arrays;
import java.util.LinkedList;

public class SampleGenerator {

	public static void main(String args[]) {
		LinkedList<Integer> population = new LinkedList<Integer>();
		population.add(8);
		population.add(14);
		population.add(16);
		population.add(10);
		population.add(11);
		System.out.println(Arrays.toString(calcSamples(population, 2, 25)));
	}

	private static double[] calcSamples(LinkedList<Integer> population, int sampleSize, int numSamples) {
		double[] means = new double[numSamples];
		for(int i = 0; i < numSamples; i++) {
			LinkedList<Integer> forTrial = (LinkedList<Integer>) population.clone();
			int total = 0;
			for(int j = 0; j < sampleSize; j++) {
				int index = random0ToN(forTrial.size());
				total += forTrial.get(index);
				forTrial.remove(index);
			}
			means[i] = total / (double) sampleSize;
		}
		return means;
	}

	private static int random0ToN(int size) {
		return (int) (Math.random() * size);
	}
}

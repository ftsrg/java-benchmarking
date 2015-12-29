package hu.bme.mit.mabel.primes;

import java.io.IOException;

import hu.bme.mit.mabel.primes.data.PrimesConfiguration;

public class PrimesBenchmark {

	public static void main(String[] args) throws IOException, InterruptedException {
		for (int max = 8; max <= 256; max = max * 2) {
			for (int numberOfCompositeNumbers = 1; numberOfCompositeNumbers <= 6; numberOfCompositeNumbers++) {
				int min = max / 2;
				PrimesConfiguration configuration = new PrimesConfiguration(2, false, numberOfCompositeNumbers, min, max);
				PrimesDefaultWorkflow.spawn(configuration);
			}
		}
	}

}

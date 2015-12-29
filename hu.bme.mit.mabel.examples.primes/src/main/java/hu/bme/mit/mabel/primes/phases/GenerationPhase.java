package hu.bme.mit.mabel.primes.phases;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;

import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.primes.data.PrimesConfiguration;

public class GenerationPhase implements Phase<List<Integer>> {

	private static final long SEED = 42;

	private final PrimesConfiguration configuration;

	public GenerationPhase(PrimesConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public List<Integer> run() {
		final List<Integer> primes = new ArrayList<>();
		final RandomGenerator randomGenerator = new MersenneTwister(SEED);
		final RandomDataGenerator randomDataGenerator = new RandomDataGenerator(randomGenerator);

		final int numberOfPrimes = configuration.getNumberOfCompositeNumbers() * 2;
		for (int i = 0; i < numberOfPrimes; i++) {
			do {
				final int x = randomDataGenerator.nextInt(configuration.getMin(), configuration.getMax());
				if (isPrime(x)) {
					primes.add(x);
					break;
				}
			} while (true);
		}

		PhaseRunner.log("Generated " + primes.size() + " primes: " + primes, configuration);
		return primes;
	}

	/**
	 * Tests if a number is prime. We deliberately use a naive algorithm.
	 * 
	 * @param x
	 * @return
	 */
	private static boolean isPrime(final long x) {
		for (long i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getName() {
		return "Generate";
	}

}

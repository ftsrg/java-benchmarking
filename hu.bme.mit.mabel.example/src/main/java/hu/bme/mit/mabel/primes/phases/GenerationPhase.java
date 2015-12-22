package hu.bme.mit.mabel.primes.phases;

import java.util.List;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;

import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.primes.data.PrimesConfiguration;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;

public class GenerationPhase extends Phase<PrimesDataToken> {

	// TODO: make these part of the configuration token as well
	protected final long SEED = 42;
	protected final int MAX = Integer.MAX_VALUE;
	protected final int MIN = MAX / 2;

	public GenerationPhase(final PrimesDataToken token) {
		super(token);
	}

	@Override
	public void run() {
		final List<Integer> primes = dataToken.getData().getPrimes();

		final RandomGenerator randomGenerator = new MersenneTwister(SEED);
		final RandomDataGenerator randomDataGenerator = new RandomDataGenerator(randomGenerator);

		final PrimesConfiguration configuration = dataToken.getConfiguration();
		final int numberOfPrimes = configuration.getNumberOfCompositeNumbers() * 2;
		for (int i = 0; i < numberOfPrimes; i++) {
			do {
				final int x = randomDataGenerator.nextInt(MIN, MAX);
				if (isPrime(x)) {
					primes.add(x);
					break;
				}
			} while (true);
		}

		System.out.println("Generated " + primes.size() + " primes");
	}

	/**
	 * Tests if a number is prime. We deliberately use a naive algorithm.
	 * 
	 * @param x
	 * @return
	 */
	private boolean isPrime(final long x) {
		for (long i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}

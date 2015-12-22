package hu.bme.mit.mabel.primes;

import java.util.List;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;

import hu.bme.mit.mabel.engine.Phase;

public class PrimeGeneratorPhase extends Phase<PrimesDataToken> {

	// TODO: make these part of the token as well
	protected final long SEED = 42;
	protected final int MIN = Integer.MAX_VALUE / 2;
	protected final int MAX = Integer.MAX_VALUE;

	@Override
	public void run() {
		final List<Long> primes = token.getPrimes();

		final RandomGenerator randomGenerator = new MersenneTwister(SEED);
		final RandomDataGenerator randomDataGenerator = new RandomDataGenerator(randomGenerator);

		for (int i = 0; i < token.getN(); i++) {
			do {
				final long x = randomDataGenerator.nextInt(MIN, MAX);
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

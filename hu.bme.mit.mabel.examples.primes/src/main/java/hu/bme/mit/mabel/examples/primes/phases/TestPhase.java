package hu.bme.mit.mabel.examples.primes.phases;

import java.util.List;

import hu.bme.mit.mabel.engine.Phase;

public class TestPhase implements Phase<Void> {

	private final List<Integer> primes;
	private final List<Integer> factors;

	public TestPhase(final List<Integer> primes, final List<Integer> factors) {
		this.primes = primes;
		this.factors = factors;
	}

	@Override
	public Void run() {
		for (int i = 0; i < primes.size() / 2; i++) {
			final int p1 = primes.get(2 * i);
			final int p2 = primes.get(2 * i + 1);

			final int f1 = factors.get(2 * i);
			final int f2 = factors.get(2 * i + 1);

			if (!((p1 == f1 && p2 == f2) || (p1 == f2 && p2 == f1))) {
				throw new AssertionError("Test failure, primes and factorized numbers differ.");
			}
		}
		return null;
	}

	@Override
	public String getName() {
		return "Test";
	}

}

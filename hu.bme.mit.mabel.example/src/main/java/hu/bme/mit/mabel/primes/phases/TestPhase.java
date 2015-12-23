package hu.bme.mit.mabel.primes.phases;

import java.util.List;

import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;
import hu.bme.mit.mabel.primes.data.PrimesPayload;

public class TestPhase extends Phase<PrimesDataToken> {

	public TestPhase(final PrimesDataToken token) {
		super(token);
	}

	@Override
	public void run() {
		final PrimesPayload data = dataToken.getPayload();

		final List<Integer> primes = data.getPrimes();
		final List<Integer> factorized = data.getFactorized();

		for (int i = 0; i < primes.size() / 2; i++) {
			final int p1 = primes.get(2 * i);
			final int p2 = primes.get(2 * i + 1);

			final int f1 = factorized.get(2 * i);
			final int f2 = factorized.get(2 * i + 1);

			if (!((p1 == f1 && p2 == f2) || (p1 == f2 && p2 == f1))) {
				throw new AssertionError("Test failure, primes and factorized numbers differ.");
			}
		}
		
		log("Test ok");
	}

}

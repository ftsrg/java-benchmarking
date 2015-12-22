package hu.bme.mit.mabel.primes.phases;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.primes.PrimesPhase;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;

public class FactorizationPhase extends PrimesPhase {

	public FactorizationPhase(final PrimesDataToken dataToken) {
		super(dataToken);
	}

	@Override
	public void run() {
		final List<Long> combined = dataToken.getData().getCombined();

		for (final Long x : combined) {
			final List<Integer> factors = factors(x);
		}

	}

	private List<Integer> factors(Long x) {
		final List<Integer> factors = new ArrayList<Integer>();

		for (int i = 2; i <= x; i++) {
			while (x % i == 0) {
				factors.add(i);
				x /= i;
			}
		}
		return factors;
	}

}

package hu.bme.mit.mabel.primes.phases;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;
import hu.bme.mit.mabel.primes.data.PrimesPayload;

public class FactorizationPhase extends Phase<PrimesDataToken> {

	public FactorizationPhase(final PrimesDataToken dataToken) {
		super(dataToken);
	}

	@Override
	public void run() {
		final PrimesPayload data = dataToken.getPayload();

		for (final Long x : data.getCombined()) {
			final List<Integer> factors = factors(x);
			data.getFactorized().addAll(factors);
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
		
		log("Factors: " + factors);
		return factors;
	}

}

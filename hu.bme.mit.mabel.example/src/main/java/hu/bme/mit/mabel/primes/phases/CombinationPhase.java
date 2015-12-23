package hu.bme.mit.mabel.primes.phases;

import java.util.List;

import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;
import hu.bme.mit.mabel.primes.data.PrimesPayload;

public class CombinationPhase extends Phase<PrimesDataToken> {
	
	public CombinationPhase(final PrimesDataToken dataToken) {
		super(dataToken);
	}

	@Override
	public void run() {
		final PrimesPayload data = dataToken.getPayload();
		final List<Integer> primes = data.getPrimes();
		final List<Long> combined = data.getCombined();

		for (int i = 0; i < primes.size() / 2; i++) {
			final long p1 = primes.get(2 * i);
			final long p2 = primes.get(2 * i + 1);
			final long c = p1 * p2;
			
			combined.add(c);
		}
	}

}

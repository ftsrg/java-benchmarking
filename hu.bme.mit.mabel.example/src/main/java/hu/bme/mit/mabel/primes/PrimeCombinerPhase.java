package hu.bme.mit.mabel.primes;

import java.util.List;

import hu.bme.mit.mabel.engine.Phase;

public class PrimeCombinerPhase extends Phase<PrimesDataToken> {
	
	@Override
	public void run() {
		final List<Long> primes = token.getPrimes();
		final List<Long> combined = token.getCombined();


		for (int i = 0; i < primes.size() / 2; i++) {
			final long p1 = primes.get(2 * i);
			final long p2 = primes.get(2 * i + 1);
			final long c = p1 * p2;
			
			combined.add(c);
		}
	}

}

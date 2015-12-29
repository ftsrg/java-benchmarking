package hu.bme.mit.mabel.primes.phases;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.engine.Phase;

public class CombinationPhase implements Phase<List<Long>> {
	
	private final List<Integer> primes;

	public CombinationPhase(List<Integer> primes) {
		this.primes = primes;
	}

	@Override
	public List<Long> run() {
		final List<Long> combined = new ArrayList<>();

		for (int i = 0; i < primes.size() / 2; i++) {
			final long p1 = primes.get(2 * i);
			final long p2 = primes.get(2 * i + 1);
			final long c = p1 * p2;
			
			combined.add(c);
		}
		return combined;
	}

	@Override
	public String getName() {
		return "Combine";
	}

}

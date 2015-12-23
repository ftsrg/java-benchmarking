package hu.bme.mit.mabel.primes.data;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.data.Payload;

public class PrimesPayload extends Payload {

	protected final List<Integer> primes;
	protected final List<Long> combined;
	protected final List<Integer> factorized;

	protected PrimesPayload(final int n) {
		super();
		primes = new ArrayList<>(n);
		combined = new ArrayList<>(n / 2);
		factorized = new ArrayList<>(n);
	}

	public static PrimesPayload create(final PrimesConfiguration configuration) {
		return new PrimesPayload(configuration.getNumberOfCompositeNumbers());
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public List<Long> getCombined() {
		return combined;
	}

	public List<Integer> getFactorized() {
		return factorized;		
	}

}

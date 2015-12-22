package hu.bme.mit.mabel.primes.data;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.engine.BenchmarkData;

public class PrimesData extends BenchmarkData {

	protected List<Integer> primes;
	protected List<Long> combined;

	protected PrimesData(final int n) {
		super();
		primes = new ArrayList<>(n);
		combined = new ArrayList<>(n / 2);
	}

	public static PrimesData create(final PrimesConfiguration configuration) {
		return new PrimesData(configuration.getNumberOfCompositeNumbers());
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public List<Long> getCombined() {
		return combined;
	}

}

package hu.bme.mit.mabel.primes.data;

import hu.bme.mit.mabel.engine.BenchmarkConfiguration;

public class PrimesConfiguration extends BenchmarkConfiguration {

	protected int n;
	private final int min;
	private final int max;
	
	public PrimesConfiguration(final int n, final int min, final int max) {
		super();
		this.n = n;
		this.min = min;
		this.max = max;
	}

	public int getN() {
		return n;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}	
	
}

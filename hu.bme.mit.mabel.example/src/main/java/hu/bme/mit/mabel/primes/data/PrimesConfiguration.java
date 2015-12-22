package hu.bme.mit.mabel.primes.data;

import hu.bme.mit.mabel.engine.BenchmarkConfiguration;

public class PrimesConfiguration extends BenchmarkConfiguration {

	protected final int runs;
	protected final int numberOfCompositeNumbers;
	private final int min;
	private final int max;
	
	public PrimesConfiguration(final int runs, final int numberOfCompositeNumbers, final int min, final int max) {
		super();
		this.runs = runs;
		this.numberOfCompositeNumbers = numberOfCompositeNumbers;
		this.min = min;
		this.max = max;
	}

	public int getRuns() {
		return runs;
	}
	
	public int getNumberOfCompositeNumbers() {
		return numberOfCompositeNumbers;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
}

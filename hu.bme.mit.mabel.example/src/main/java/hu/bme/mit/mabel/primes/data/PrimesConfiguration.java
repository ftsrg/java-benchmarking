package hu.bme.mit.mabel.primes.data;

import hu.bme.mit.mabel.data.Configuration;

public class PrimesConfiguration extends Configuration {

	protected final int numberOfCompositeNumbers;
	private final int min;
	private final int max;
	
	public PrimesConfiguration(final int runs, final boolean verbose, final int numberOfCompositeNumbers, final int min, final int max) {
		super(runs, verbose);
		this.numberOfCompositeNumbers = numberOfCompositeNumbers;
		this.min = min;
		this.max = max;
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

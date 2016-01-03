package hu.bme.mit.mabel.examples.primes.data;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import hu.bme.mit.mabel.data.Configuration;

public class PrimesConfiguration extends Configuration {

	@Option(name = "-composite", usage = "number of composite numbers")
	private int numberOfCompositeNumbers;

	@Option(name = "-min", usage = "minimum value")
	private int min;

	@Option(name = "-max", usage = "maximum value")
	private int max;

	public PrimesConfiguration(final int runs, final boolean verbose, final int numberOfCompositeNumbers, final int min, final int max) {
		super(runs, verbose);
		this.numberOfCompositeNumbers = numberOfCompositeNumbers;
		this.min = min;
		this.max = max;
	}

	protected PrimesConfiguration() {
	}

	public static PrimesConfiguration parse(final String[] args) throws CmdLineException {
		final PrimesConfiguration configuration = new PrimesConfiguration();
		new CmdLineParser(configuration).parseArgument(args);
		return configuration;
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

	@Override
	public String getSubject() {
		return "Naive";
	}

}

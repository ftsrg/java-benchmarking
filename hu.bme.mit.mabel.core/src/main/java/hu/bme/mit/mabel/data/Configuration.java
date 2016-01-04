package hu.bme.mit.mabel.data;

import java.util.List;

import org.kohsuke.args4j.Option;

import com.google.common.collect.ImmutableList;

/**
 * The input parameters of a benchmark workflow.
 */
public abstract class Configuration {

	@Option(required = true, name = "-runs", usage = "number of runs")
	protected int runs;

	@Option(name = "-verbose", usage = "show verbose output")
	protected boolean verbose;

	public Configuration(final int runs, final boolean verbose) {
		super();
		this.runs = runs;
		this.verbose = verbose;
	}

	protected Configuration() {
	}


	public int getRuns() {
		return runs;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public abstract String getSubject();

	public List<String> getJvmArguments() {
		return ImmutableList.of("-Xms2G", "-Xmx2G");
	}

}

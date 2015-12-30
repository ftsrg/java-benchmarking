package hu.bme.mit.mabel.data;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * The input parameters of a benchmark workflow. 
 */
public class Configuration {
	
	@Option(name = "-runs", usage = "number of runs")
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

	/**
	 * Parses a {@link Configuration} from the given command-line arguments. 
	 */
	public static Configuration parse(String[] args) throws CmdLineException {
		Configuration configuration = new Configuration();
		new CmdLineParser(configuration).parseArgument(args);
		return configuration;
	}
	
	public int getRuns() {
		return runs;
	}
	
	public boolean isVerbose() {
		return verbose;
	}	
	
}

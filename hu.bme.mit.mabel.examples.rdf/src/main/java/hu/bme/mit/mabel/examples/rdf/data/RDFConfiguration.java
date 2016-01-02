package hu.bme.mit.mabel.examples.rdf.data;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import hu.bme.mit.mabel.data.Configuration;

public class RDFConfiguration extends Configuration {

	@Option(name = "-model", usage = "path to the RDF model")
	private String modelPath;

	@Option(name = "-queries", usage = "number of queries to perform")
	private int queries;

	public RDFConfiguration(final int runs, final boolean verbose, final String modelPath, final int queries) {
		super(runs, verbose);
		this.modelPath = modelPath;
		this.queries = queries;
	}

	protected RDFConfiguration() {
	}

	public static RDFConfiguration parse(final String[] args) throws CmdLineException {
		final RDFConfiguration configuration = new RDFConfiguration();
		new CmdLineParser(configuration).parseArgument(args);
		return configuration;
	}

	public String getModelPath() {
		return modelPath;
	}

	public int getQueries() {
		return queries;
	}

}

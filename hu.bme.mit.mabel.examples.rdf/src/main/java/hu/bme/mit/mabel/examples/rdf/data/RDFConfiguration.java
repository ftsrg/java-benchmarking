package hu.bme.mit.mabel.examples.rdf.data;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import hu.bme.mit.mabel.data.Configuration;
import hu.bme.mit.mabel.examples.rdf.RDFToolFactory;
import hu.bme.mit.mabel.examples.rdf.jena.JenaFactory;
import hu.bme.mit.mabel.examples.rdf.sesame.SesameFactory;

public class RDFConfiguration extends Configuration {

	@Option(name = "-model", required = true, usage = "path to the RDF model")
	private String modelPath;

	@Option(name = "-queries", required = true, usage = "number of queries to perform")
	private int queries;

	@Option(name = "-tool", required = true, usage = "the RDF tool to benchmark")
	private RDFTool tool;

	public RDFConfiguration(final int runs, final boolean verbose, final String modelPath, final int queries, final RDFTool tool) {
		super(runs, verbose);
		this.modelPath = modelPath;
		this.queries = queries;
		this.tool = tool;
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

	public RDFToolFactory<?, ?> getTool() {
		switch (tool) {
		case JENA:
			return new JenaFactory();
		case SESAME:
			return new SesameFactory();
		default:
			throw new Error("Unsupported tool " + tool);
		}
	}

}

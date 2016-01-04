package hu.bme.mit.mabel.examples.rdf.data;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import hu.bme.mit.mabel.data.Configuration;
import hu.bme.mit.mabel.examples.rdf.RDFToolFactory;
import hu.bme.mit.mabel.examples.rdf.jena.JenaFactory;
import hu.bme.mit.mabel.examples.rdf.sesame.SesameFactory;

public class RDFConfiguration extends Configuration {

	protected final String query1 = "SELECT DISTINCT ?s1 WHERE {?s1 ?p1 ?o1 . ?s1 ?p2 ?o2 . FILTER (?p1 != ?p2)}";
	protected final String query2 = "SELECT DISTINCT ?s WHERE {?s ?p ?o }";

	@Option(name = "-size", required = true, usage = "size of the RDF model")
	private int modelSize;

	@Option(name = "-queries", required = true, usage = "number of queries to perform")
	private int queries;

	@Option(name = "-tool", required = true, usage = "the RDF tool to benchmark")
	private RDFTool tool;

	public RDFConfiguration(final int runs, final boolean verbose, final int modelSize, final int queries, final RDFTool tool) {
		super(runs, verbose);
		this.modelSize = modelSize;
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
		return "models/railway-repair-" + modelSize + "-inferred.ttl";
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

	@Override
	public String getSubject() {
		return tool.toString();
	}

	public String getQuery1() {
		return query1;
	}

	public String getQuery2() {
		return query2;
	}

	@Override
	public String getArtifact() {
		return Integer.toString(modelSize);
	}

}

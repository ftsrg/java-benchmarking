package hu.bme.mit.mabel.examples.rdf;

import java.io.IOException;
import java.util.List;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Model;
import org.kohsuke.args4j.CmdLineException;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.engine.WorkflowRunner;
import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;
import hu.bme.mit.mabel.examples.rdf.jena.JenaFactory;
import hu.bme.mit.mabel.examples.rdf.metrics.MatchesMetric;
import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;
import hu.bme.mit.mabel.metrics.Metric;

public class RDFDefaultWorkflow {

	public static void run(final RDFConfiguration configuration) {
		final Results results = new Results();
		for (int run = 1; run <= configuration.getRuns(); run++) {
			final ExecutionId executionId = new ExecutionId(run);

			final JenaFactory factory = new JenaFactory();
			final Model databaseConnection1 = PhaseRunner.run(factory.createInitPhase(), executionId, results);
			final Model databaseConnection2 = PhaseRunner.run(factory.createLoadPhase(databaseConnection1, configuration.getModelPath()), executionId, results);

			for (int query = 1; query <= configuration.getQueries(); query++) {
				final ExecutionId queryExecutionId = new ExecutionId(run, query);

				final QueryPhase<Model, List<QuerySolution>> queryPhase = factory.createQueryPhase(databaseConnection2);
				final List<QuerySolution> bindingSets = PhaseRunner.run(queryPhase, queryExecutionId, results);

				factory.createQueryPhase(databaseConnection2);
				final Metric<?> matches = new MatchesMetric(queryPhase, queryExecutionId, bindingSets.size());
				results.recordMetric(matches);
			}
		}
		System.out.print(results);
	}

	public static void spawn(final RDFConfiguration configuration) throws IOException, InterruptedException {
		WorkflowRunner.spawn(RDFDefaultWorkflow.class, configuration);
	}

	public static void main(final String[] args) throws CmdLineException {
		final RDFConfiguration configuration = RDFConfiguration.parse(args);
		run(configuration);
	}

}

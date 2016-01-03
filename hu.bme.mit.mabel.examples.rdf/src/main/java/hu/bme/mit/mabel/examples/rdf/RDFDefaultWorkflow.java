package hu.bme.mit.mabel.examples.rdf;

import java.io.IOException;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.engine.WorkflowRunner;
import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;
import hu.bme.mit.mabel.examples.rdf.metrics.MatchesMetric;
import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;
import hu.bme.mit.mabel.metrics.Metric;

public class RDFDefaultWorkflow {

	public static void run(final RDFConfiguration configuration) {
		final RDFToolFactory<?, ?> factory = configuration.getTool();
		doRun(configuration, factory);
	}

	private static <DatabaseConnection, QueryResult> void doRun(final RDFConfiguration configuration, final RDFToolFactory<DatabaseConnection, QueryResult> factory) {
		final Results results = new Results();
		for (int run = 1; run <= configuration.getRuns(); run++) {
			final ExecutionId executionId = new ExecutionId(factory.getName(), run);

			final DatabaseConnection databaseConnectionEmpty = PhaseRunner.run(factory.createInitPhase(), executionId, results);
			final DatabaseConnection databaseConnectionLoaded = PhaseRunner.run(factory.createLoadPhase(databaseConnectionEmpty, configuration.getModelPath()), executionId, results);

			for (int query = 1; query <= configuration.getQueries(); query++) {
				final ExecutionId queryExecutionId = new ExecutionId(factory.getName(), run, query);

				final QueryPhase<DatabaseConnection, QueryResult> queryPhase = factory.createQueryPhase(databaseConnectionLoaded);
				final List<QueryResult> queryResults = PhaseRunner.run(queryPhase, queryExecutionId, results);

				factory.createQueryPhase(databaseConnectionLoaded);
				final Metric<?> matches = new MatchesMetric(queryPhase, queryExecutionId, queryResults.size());
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

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
		final Results results = new Results(configuration);
		for (int run = 1; run <= configuration.getRuns(); run++) {
			final ExecutionId executionId = new ExecutionId(run);

			final DatabaseConnection databaseConnectionEmpty = PhaseRunner.run(factory.createInitPhase(), executionId, results);
			final DatabaseConnection databaseConnectionLoaded = PhaseRunner.run(factory.createLoadPhase(databaseConnectionEmpty, configuration.getModelPath()), executionId, results);

			for (int query = 1; query <= configuration.getQueries(); query++) {
				final ExecutionId query1ExecutionId = new ExecutionId(run, query, 1);
				final QueryPhase<DatabaseConnection, QueryResult> query1Phase = factory.createQueryPhase(databaseConnectionLoaded, configuration.getQuery1());
				final List<QueryResult> query1Results = PhaseRunner.run(query1Phase, query1ExecutionId, results);

				final Metric<?> matches1 = new MatchesMetric(query1Phase, query1ExecutionId, query1Results.size());
				results.recordMetric(matches1);

				final ExecutionId query2ExecutionId = new ExecutionId(run, query, 2);
				final QueryPhase<DatabaseConnection, QueryResult> query2Phase = factory.createQueryPhase(databaseConnectionLoaded, configuration.getQuery2());
				final List<QueryResult> query2Results = PhaseRunner.run(query2Phase, query2ExecutionId, results);

				final Metric<?> matches2 = new MatchesMetric(query2Phase, query2ExecutionId, query2Results.size());
				results.recordMetric(matches2);
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

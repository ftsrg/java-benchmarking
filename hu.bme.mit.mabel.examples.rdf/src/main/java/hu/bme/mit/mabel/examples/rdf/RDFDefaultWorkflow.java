package hu.bme.mit.mabel.examples.rdf;

import java.io.IOException;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.openrdf.query.BindingSet;
import org.openrdf.repository.RepositoryConnection;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.engine.WorkflowRunner;
import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;
import hu.bme.mit.mabel.examples.rdf.metrics.MatchesMetric;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameInitPhase;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameLoadPhase;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameQueryPhase;
import hu.bme.mit.mabel.metrics.Metric;

public class RDFDefaultWorkflow {

	public static void run(final RDFConfiguration configuration) {
		final Results results = new Results();
		for (int run = 1; run <= configuration.getRuns(); run++) {
			final ExecutionId executionId = new ExecutionId(run);
			final RepositoryConnection repositoryConnection1 = PhaseRunner.run(new SesameInitPhase(), executionId, results);
			final RepositoryConnection repositoryConnection2 = PhaseRunner.run(new SesameLoadPhase(repositoryConnection1, configuration.getModelPath()), executionId, results);

			for (int query = 1; query <= configuration.getQueries(); query++) {
				final ExecutionId queryExecutionId = new ExecutionId(run, query);
				final SesameQueryPhase queryPhase = new SesameQueryPhase(repositoryConnection2);
				final List<BindingSet> bindingSets = PhaseRunner.run(queryPhase, queryExecutionId, results);
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

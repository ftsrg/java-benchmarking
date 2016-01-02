package hu.bme.mit.mabel.examples.rdf.metrics;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;
import hu.bme.mit.mabel.metrics.Metric;

/**
 * Stores the number of matches retrieved in {@link QueryPhase} execution.
 */
public class MatchesMetric extends Metric<Long> {

	public MatchesMetric(final Phase<?> phase, final ExecutionId executionId, final long matches) {
		super(phase, executionId, matches);
	}

	@Override
	public String getName() {
		return "Matches";
	}

}

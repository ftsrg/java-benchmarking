package hu.bme.mit.mabel.metrics;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.engine.Phase;

/**
 * Stores the time elapsed during a {@link Phase} execution, in nanoseconds. 
 */
public class TimeMetric extends Metric<Long> {

	public TimeMetric(Phase<?> phase, ExecutionId executionId, long elapsed) {
		super(phase, executionId, elapsed);
	}

	@Override
	public String getName() {
		return "Time";
	}
	
}

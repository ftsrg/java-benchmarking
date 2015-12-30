package hu.bme.mit.mabel.metrics;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.engine.Phase;

public class TimeMetric extends Metric<Long> {

	public TimeMetric(Phase<?> phase, ExecutionId executionId, long elapsed) {
		super(phase, executionId, elapsed);
	}

	@Override
	public String getName() {
		return "Time";
	}
	
}

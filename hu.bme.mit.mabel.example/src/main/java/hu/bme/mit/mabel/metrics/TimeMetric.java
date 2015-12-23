package hu.bme.mit.mabel.metrics;

import hu.bme.mit.mabel.engine.Phase;

public class TimeMetric extends Metric<Long> {

	public TimeMetric(final int run, final Phase<?> phase, final int id, final Long value) {
		super(run, phase, id, value);
	}

	@Override
	public String getName() {
		return "Time";
	}
	
}

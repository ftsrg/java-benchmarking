package hu.bme.mit.mabel.metrics;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.engine.Phase;

/**
 * Stores a measured metric of a {@link Phase} execution.
 */
public abstract class Metric<TValue> {

	private final Phase<?> phase;
	private final ExecutionId executionId;
	private final TValue value;

	public Metric(final Phase<?> phase, final ExecutionId executionId, final TValue value) {
		this.phase = phase;
		this.executionId = executionId;
		this.value = value;
	}

	/**
	 * The name of the {@link Metric}.
	 */
	public abstract String getName();

	/**
	 * The name of the measured {@link Phase}.
	 */
	public String getPhaseName() {
		return phase.getName();
	}

	/**
	 * The value associated with the {@link Metric}.
	 */
	public TValue getValue() {
		return value;
	}

	public ExecutionId getExecutionId() {
		return executionId;
	}

}

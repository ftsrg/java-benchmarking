package hu.bme.mit.mabel.metrics;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.engine.Phase;

public abstract class Metric<TValue> {

	private final Phase<?> phase;
	private final ExecutionId executionId;
	private final TValue value;

	public Metric(final Phase<?> phase, final ExecutionId executionId, final TValue value) {
		this.phase = phase;
		this.executionId = executionId;
		this.value = value;
	}

	public abstract String getName();

	public String getPhaseName() {
		return phase.getName();
	}
	
	public TValue getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%d", executionId.getRun(), executionId.getPhaseInstanceIdString(), phase.getName(), getName(), value);
	}

	public static String getHeader() {
		return "Run,Id,Phase,Metric,Value\n";
	}

}

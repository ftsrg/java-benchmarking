package hu.bme.mit.mabel.metrics;

import hu.bme.mit.mabel.engine.Phase;

public abstract class Metric<TValue> {

	protected final Phase<?> phase;
	protected final int id;
	protected final TValue value;

	public Metric(final Phase<?> phase, final int id, final TValue value) {
		this.phase = phase;
		this.id = id;
		this.value = value;
	}

	public abstract String getName();

	public String getPhaseName() {
		return phase.getName();
	}
	
	public int getId() {
		return id;
	}
	
	public TValue getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%d,%s,%d", id, phase.getName(), value);
	}

}

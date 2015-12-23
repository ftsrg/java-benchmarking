package hu.bme.mit.mabel.metrics;

import hu.bme.mit.mabel.engine.Phase;

public abstract class Metric<TValue> {

	protected final int run;
	protected final Phase<?> phase;
	protected final int id;
	protected final TValue value;

	public Metric(final int run, final Phase<?> phase, final int id, final TValue value) {
		this.run = run;
		this.phase = phase;
		this.id = id;
		this.value = value;
	}

	public abstract String getName();

	public String getPhaseName() {
		return phase.getName();
	}
	
	public int getRun() {
		return run;
	}
	
	public int getId() {
		return id;
	}
	
	public TValue getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%d,%d,%s,%s,%d", run, id, phase.getName(), getName(), value);
	}

	public static String getHeader() {
		return "Run,Id,Phase,Metric,Value\n";
	}

}

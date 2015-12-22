package hu.bme.mit.mabel.engine;

import com.google.common.base.Stopwatch;

public class PhaseRunner<TPhase extends Phase<TDataToken>, TDataToken extends DataToken<? extends BenchmarkConfiguration, ? extends BenchmarkData, ? extends BenchmarkResults>> {

	protected final TPhase phase;

	public PhaseRunner(final TPhase phase) {
		this.phase = phase;
	}

	public final void run() {
		final Stopwatch stopwatch = Stopwatch.createStarted();
		phase.run();
		stopwatch.stop();
		// final long elapsed = stopwatch.elapsed(TimeUnit.NANOSECONDS);
	}

}

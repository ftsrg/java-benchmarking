package hu.bme.mit.mabel.engine;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.metrics.Metric;
import hu.bme.mit.mabel.metrics.TimeMetric;

public class PhaseRunner {

	/**
	 * Runs the given {@link Phase} whose execution is identified by the given {@link ExecutionId},
	 * records the measured {@link Metric}s to the given {@link Results}, and returns the output of the {@link Phase}.
	 */
	public static <Value> Value run(final Phase<Value> phase, final ExecutionId executionId, final Results results) {
		final Stopwatch stopwatch = Stopwatch.createStarted();
		try {
			final Value value = phase.run();
			final long elapsed = stopwatch.elapsed(TimeUnit.NANOSECONDS);
			final TimeMetric metric = new TimeMetric(phase, executionId, elapsed);
			results.recordMetric(metric);
			return value;
		} catch (final Exception e) {
			throw Throwables.propagate(e);
		} finally {
			stopwatch.stop();
		}
	}

}

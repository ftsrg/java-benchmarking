package hu.bme.mit.mabel.engine;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;

import hu.bme.mit.mabel.data.Configuration;
import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.metrics.TimeMetric;

public class PhaseRunner {

	public static <Value> Value run(Phase<Value> phase, int run, Results results) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		try {
			Value value = phase.run();
			final long elapsed = stopwatch.elapsed(TimeUnit.NANOSECONDS);
			final TimeMetric metric = new TimeMetric(run, phase, 0, elapsed);
			results.recordMetric(metric);
			return value;
		} catch (Exception e) {
			throw Throwables.propagate(e);
		} finally {
			stopwatch.stop();
		}
	}

	public static void log(final String message, Configuration configuration) {
		if (configuration.isVerbose()) {
			System.out.println(message);
		}
	}

}

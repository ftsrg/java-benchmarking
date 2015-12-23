package hu.bme.mit.mabel.engine;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import hu.bme.mit.mabel.data.Configuration;
import hu.bme.mit.mabel.data.DataToken;
import hu.bme.mit.mabel.data.Payload;
import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.metrics.TimeMetric;

public abstract class Phase<TDataToken extends DataToken<? extends Configuration, ? extends Payload, ? extends Results>>
		implements Runnable {

	protected TDataToken dataToken;
	protected Stopwatch stopwatch;

	public Phase(final TDataToken dataToken) {
		super();
		this.dataToken = dataToken;
	}

	@Override
	public abstract void run();

	public void init() {
		stopwatch = Stopwatch.createStarted();
	}

	public void finish() {
		stopwatch.stop();
		final long elapsed = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		final TimeMetric metric = new TimeMetric(0, this, 0, elapsed);
		dataToken.getResults().recordMetric(metric);
	}

	public void log(final String message) {
		if (dataToken.getConfiguration().isVerbose()) {
			System.out.println(message);
		}
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public TDataToken getDataToken() {
		return dataToken;
	}

}

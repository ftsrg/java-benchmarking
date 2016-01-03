package hu.bme.mit.mabel.data;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.metrics.Metric;

/**
 * The output of a benchmark workflow, containing the collected {@link Metric}s.
 */
public class Results {

	protected final Configuration configuration;
	protected final List<Metric<?>> metrics = new ArrayList<>();

	public Results(final Configuration configuration) {
		this.configuration = configuration;
	}

	public List<Metric<?>> getMetrics() {
		return metrics;
	}

	public void recordMetric(final Metric<?> metric) {
		metrics.add(metric);
	}

	@Override
	public String toString() {
		String results = Metric.getHeader();
		for (final Metric<?> metric : metrics) {
			results += String.format("%s,%d,%s,%s,%s,%d",
					configuration.getSubject(),
					metric.getExecutionId().getRun(),
					metric.getExecutionId().getPhaseInstanceIdString(),
					metric.getPhaseName(),
					metric.getName(),
					metric.getValue());
			results += "\n";
		}
		return results;
	}

}

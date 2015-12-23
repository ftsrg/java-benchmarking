package hu.bme.mit.mabel.data;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.metrics.Metric;

public class Results {

	protected final List<Metric<?>> metrics = new ArrayList<>();
	
	public List<Metric<?>> getMetrics() {
		return metrics;
	}
	
	public void recordMetric(final Metric<?> metric) {
		metrics.add(metric);
	}
	
	@Override
	public String toString() {
		String results = "";
		for (final Metric<?> metric : metrics) {
			results += metric.toString() + "\n";
		}
		return results;
	}
	
}

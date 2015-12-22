package hu.bme.mit.mabel.engine;

public abstract class DataToken<TBenchmarkConfiguration extends BenchmarkConfiguration, TBenchmarkData extends BenchmarkData, TBenchmarkResults extends BenchmarkResults> {

	protected final TBenchmarkConfiguration configuration;
	protected final TBenchmarkData data;
	protected final TBenchmarkResults results;

	public DataToken(final TBenchmarkConfiguration configuration, final TBenchmarkData data,
			final TBenchmarkResults results) {
		super();
		this.configuration = configuration;
		this.data = data;
		this.results = results;
	}

	public TBenchmarkConfiguration getConfiguration() {
		return configuration;
	}

	public TBenchmarkData getData() {
		return data;
	}

	public TBenchmarkResults getResults() {
		return results;
	}

}

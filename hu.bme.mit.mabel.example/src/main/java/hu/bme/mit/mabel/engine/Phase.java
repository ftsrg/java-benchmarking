package hu.bme.mit.mabel.engine;

public abstract class Phase<TDataToken extends DataToken<? extends BenchmarkConfiguration, ? extends BenchmarkData, ? extends BenchmarkResults>>
		implements Runnable {

	protected TDataToken dataToken;

	@Override
	public abstract void run();

	public Phase(final TDataToken dataToken) {
		super();
		this.dataToken = dataToken;
	}

	public TDataToken getDataToken() {
		return dataToken;
	}

}

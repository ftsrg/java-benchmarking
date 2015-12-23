package hu.bme.mit.mabel.data;

public abstract class DataToken<TConfiguration extends Configuration, TPayload extends Payload, TResults extends Results> {

	protected final TConfiguration configuration;
	protected final TPayload payload;
	protected final TResults results;

	public DataToken(final TConfiguration configuration, final TPayload payload,
			final TResults results) {
		super();
		this.configuration = configuration;
		this.payload = payload;
		this.results = results;
	}

	public TConfiguration getConfiguration() {
		return configuration;
	}

	public TPayload getPayload() {
		return payload;
	}

	public TResults getResults() {
		return results;
	}

}

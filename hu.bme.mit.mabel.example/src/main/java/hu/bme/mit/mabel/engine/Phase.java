package hu.bme.mit.mabel.engine;

public abstract class Phase<T extends DataToken> {
	
	protected T token;

	public void init(final T token) {
		this.token = token;
	}
	
	public abstract void run();

}

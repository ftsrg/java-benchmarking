package hu.bme.mit.mabel.data;

public class Configuration {
	
	protected final int runs;
	protected final boolean verbose;
	
	public Configuration(final int runs, final boolean verbose) {
		super();
		this.runs = runs;
		this.verbose = verbose;
	}
	
	public int getRuns() {
		return runs;
	}
	
	public boolean isVerbose() {
		return verbose;
	}	
	
}

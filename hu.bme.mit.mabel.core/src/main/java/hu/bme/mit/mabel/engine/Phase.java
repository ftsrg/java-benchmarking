package hu.bme.mit.mabel.engine;

/**
 * A discrete step of a benchmark.
 */
public interface Phase<Value> {

	/**
	 * The logic that has to be measured.
	 */
	Value run();

	/**
	 * The name of the {@link Phase}.
	 */
	String getName();
	
}

package hu.bme.mit.mabel.engine;

import hu.bme.mit.mabel.data.Configuration;

public class BenchmarkUtils {

	/**
	 * Logs the given message if verbose output is set in the given {@link Configuration}.
	 */
	public static void log(final String message, Configuration configuration) {
		if (configuration.isVerbose()) {
			System.out.println(message);
		}
	}

}

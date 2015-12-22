package hu.bme.mit.mabel.engine;

import com.google.common.base.Stopwatch;

public class PhaseRunner {

	protected final Phase phase;

	private PhaseRunner(final Phase phase) {
		this.phase = phase;
	}

	public static PhaseRunner newInstance(final Class<? extends Phase> phaseClass, final DataToken token) throws InstantiationException, IllegalAccessException {		
		final Phase phase = phaseClass.newInstance();
		phase.init(token);

		final PhaseRunner phaseRunner = new PhaseRunner(phase);
		return phaseRunner;
	}

	public void run() {
		final Stopwatch stopwatch = Stopwatch.createStarted();
		phase.run();
		stopwatch.stop();
	}

}

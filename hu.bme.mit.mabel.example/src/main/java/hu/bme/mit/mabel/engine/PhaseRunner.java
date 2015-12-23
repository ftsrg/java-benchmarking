package hu.bme.mit.mabel.engine;

import hu.bme.mit.mabel.data.Configuration;
import hu.bme.mit.mabel.data.DataToken;
import hu.bme.mit.mabel.data.Payload;
import hu.bme.mit.mabel.data.Results;

public class PhaseRunner<TPhase extends Phase<TDataToken>, TDataToken extends DataToken<? extends Configuration, ? extends Payload, ? extends Results>> {

	protected final TPhase phase;

	public PhaseRunner(final TPhase phase) {
		this.phase = phase;
	}

	public final void run() {
		phase.init();
		phase.run();
		phase.finish();
	}
	

}

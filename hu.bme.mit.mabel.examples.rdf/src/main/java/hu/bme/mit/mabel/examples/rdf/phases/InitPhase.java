package hu.bme.mit.mabel.examples.rdf.phases;

import hu.bme.mit.mabel.engine.Phase;

public abstract class InitPhase<DatabaseConnection> implements Phase<DatabaseConnection> {

	public InitPhase() {
		super();
	}

	@Override
	public String getName() {
		return "Init";
	}

}

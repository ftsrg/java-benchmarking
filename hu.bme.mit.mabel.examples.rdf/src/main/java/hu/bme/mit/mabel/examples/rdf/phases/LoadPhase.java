package hu.bme.mit.mabel.examples.rdf.phases;

import hu.bme.mit.mabel.engine.Phase;

public abstract class LoadPhase<DatabaseConnection> implements Phase<DatabaseConnection> {

	protected final DatabaseConnection databaseConnection;
	protected final String modelPath;

	public LoadPhase(final DatabaseConnection databaseConnection, final String modelPath) {
		super();
		this.modelPath = modelPath;
		this.databaseConnection = databaseConnection;
	}

	@Override
	public String getName() {
		return "Load";
	}

}

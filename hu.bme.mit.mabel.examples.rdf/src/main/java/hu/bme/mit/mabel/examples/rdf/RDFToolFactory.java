package hu.bme.mit.mabel.examples.rdf;

import hu.bme.mit.mabel.examples.rdf.phases.InitPhase;
import hu.bme.mit.mabel.examples.rdf.phases.LoadPhase;
import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;

public abstract class RDFToolFactory<DatabaseConnection, QueryResult> {

	public abstract InitPhase<DatabaseConnection> createInitPhase();

	public abstract LoadPhase<DatabaseConnection> createLoadPhase(DatabaseConnection databaseConnection, String modelPath);

	public abstract QueryPhase<DatabaseConnection, QueryResult> createQueryPhase(DatabaseConnection databaseConnection);

}

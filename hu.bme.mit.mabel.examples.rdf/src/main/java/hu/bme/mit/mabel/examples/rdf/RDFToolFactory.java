package hu.bme.mit.mabel.examples.rdf;

import hu.bme.mit.mabel.examples.rdf.phases.InitPhase;
import hu.bme.mit.mabel.examples.rdf.phases.LoadPhase;
import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;

public interface RDFToolFactory<DatabaseConnection, QueryResult> {

	InitPhase<DatabaseConnection> createInitPhase();

	LoadPhase<DatabaseConnection> createLoadPhase(DatabaseConnection databaseConnection, String modelPath);

	QueryPhase<DatabaseConnection, QueryResult> createQueryPhase(DatabaseConnection databaseConnection);

	String getName();

}

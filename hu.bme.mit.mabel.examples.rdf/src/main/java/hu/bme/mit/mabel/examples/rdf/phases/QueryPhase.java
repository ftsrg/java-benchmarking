package hu.bme.mit.mabel.examples.rdf.phases;

import java.util.List;

import hu.bme.mit.mabel.engine.Phase;

public abstract class QueryPhase<DatabaseConnection, QueryResult> implements Phase<List<QueryResult>> {

	protected final String query = "SELECT (COUNT(*) AS ?count) WHERE {?s ?p ?o}";
	protected final DatabaseConnection databaseConnection;

	public QueryPhase(final DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	@Override
	public String getName() {
		return "Query";
	}

}

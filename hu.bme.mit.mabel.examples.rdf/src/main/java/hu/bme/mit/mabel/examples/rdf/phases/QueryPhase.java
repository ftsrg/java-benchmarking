package hu.bme.mit.mabel.examples.rdf.phases;

import java.util.List;

import hu.bme.mit.mabel.engine.Phase;

public abstract class QueryPhase<DatabaseConnection, QueryResult> implements Phase<List<QueryResult>> {

	protected final String query;
	protected final DatabaseConnection databaseConnection;

	public QueryPhase(final DatabaseConnection databaseConnection, final String query) {
		this.databaseConnection = databaseConnection;
		this.query = query;
	}

	@Override
	public String getName() {
		return "Query";
	}

}

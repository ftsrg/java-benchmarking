package hu.bme.mit.mabel.examples.rdf.phases;

import java.util.ArrayList;
import java.util.List;

import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.RepositoryConnection;

import hu.bme.mit.mabel.engine.Phase;

public class QueryPhase implements Phase<List<BindingSet>> {

	final String query = "SELECT (COUNT(*) AS ?count) WHERE {?s ?p ?o}";
	final RepositoryConnection repositoryConnection;

	public QueryPhase(final RepositoryConnection repositoryConnection) {
		this.repositoryConnection = repositoryConnection;
	}

	@Override
	public List<BindingSet> run() {
		final List<BindingSet> bindingSets = new ArrayList<>();
		final TupleQuery tupleQuery = repositoryConnection.prepareTupleQuery(QueryLanguage.SPARQL, query);
		try (TupleQueryResult queryResults = tupleQuery.evaluate()) {
			while (queryResults.hasNext()) {
				final BindingSet bindingSet = queryResults.next();
				bindingSets.add(bindingSet);
			}
		}
		return bindingSets;
	}

	@Override
	public String getName() {
		return "Query";
	}

}

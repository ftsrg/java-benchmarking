package hu.bme.mit.mabel.examples.rdf.sesame.phases;

import java.util.ArrayList;
import java.util.List;

import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.RepositoryConnection;

import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;

public class SesameQueryPhase extends QueryPhase<RepositoryConnection, BindingSet> {

	public SesameQueryPhase(final RepositoryConnection repositoryConnection, final String query) {
		super(repositoryConnection, query);
	}

	@Override
	public List<BindingSet> run() {
		final List<BindingSet> bindingSets = new ArrayList<>();
		final TupleQuery tupleQuery = databaseConnection.prepareTupleQuery(QueryLanguage.SPARQL, query);
		try (TupleQueryResult queryResults = tupleQuery.evaluate()) {
			while (queryResults.hasNext()) {
				final BindingSet bindingSet = queryResults.next();
				bindingSets.add(bindingSet);
			}
		}
		return bindingSets;
	}

}

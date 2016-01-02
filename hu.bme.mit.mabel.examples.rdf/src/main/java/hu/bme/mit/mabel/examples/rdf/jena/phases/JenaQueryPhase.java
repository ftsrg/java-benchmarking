package hu.bme.mit.mabel.examples.rdf.jena.phases;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;

public class JenaQueryPhase extends QueryPhase<Model, List<QuerySolution>> {

	final String query = "SELECT (COUNT(*) AS ?count) WHERE {?s ?p ?o}";

	public JenaQueryPhase(final Model model) {
		super(model);
	}

	@Override
	public List<QuerySolution> run() {
		final List<QuerySolution> results = new ArrayList<>();
		try (QueryExecution queryExecution = QueryExecutionFactory.create(query, databaseConnection)) {
			final ResultSet resultSet = queryExecution.execSelect();

			while (resultSet.hasNext()) {
				final QuerySolution querySolution = resultSet.next();
				results.add(querySolution);
			}
		}
		return results;
	}

}

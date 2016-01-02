package hu.bme.mit.mabel.examples.rdf.jena;

import java.util.List;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.Model;

import hu.bme.mit.mabel.examples.rdf.RDFToolFactory;
import hu.bme.mit.mabel.examples.rdf.jena.phases.JenaInitPhase;
import hu.bme.mit.mabel.examples.rdf.jena.phases.JenaLoadPhase;
import hu.bme.mit.mabel.examples.rdf.jena.phases.JenaQueryPhase;
import hu.bme.mit.mabel.examples.rdf.phases.InitPhase;
import hu.bme.mit.mabel.examples.rdf.phases.LoadPhase;
import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;

public class JenaFactory extends RDFToolFactory<Model, List<QuerySolution>> {

	@Override
	public InitPhase<Model> createInitPhase() {
		return new JenaInitPhase();
	}

	@Override
	public LoadPhase<Model> createLoadPhase(final Model databaseConnection, final String modelPath) {
		return new JenaLoadPhase(databaseConnection, modelPath);
	}

	@Override
	public QueryPhase<Model, List<QuerySolution>> createQueryPhase(final Model databaseConnection) {
		return new JenaQueryPhase(databaseConnection);
	}




}

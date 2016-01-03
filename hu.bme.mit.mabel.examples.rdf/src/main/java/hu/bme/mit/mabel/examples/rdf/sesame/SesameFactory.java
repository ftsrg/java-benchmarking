package hu.bme.mit.mabel.examples.rdf.sesame;

import org.openrdf.query.BindingSet;
import org.openrdf.repository.RepositoryConnection;

import hu.bme.mit.mabel.examples.rdf.RDFToolFactory;
import hu.bme.mit.mabel.examples.rdf.phases.InitPhase;
import hu.bme.mit.mabel.examples.rdf.phases.LoadPhase;
import hu.bme.mit.mabel.examples.rdf.phases.QueryPhase;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameInitPhase;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameLoadPhase;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameQueryPhase;

public class SesameFactory implements RDFToolFactory<RepositoryConnection, BindingSet> {

	@Override
	public InitPhase<RepositoryConnection> createInitPhase() {
		return new SesameInitPhase();
	}

	@Override
	public LoadPhase<RepositoryConnection> createLoadPhase(final RepositoryConnection databaseConnection, final String modelPath) {
		return new SesameLoadPhase(databaseConnection, modelPath);
	}

	@Override
	public QueryPhase<RepositoryConnection, BindingSet> createQueryPhase(final RepositoryConnection databaseConnection) {
		return new SesameQueryPhase(databaseConnection);
	}

}

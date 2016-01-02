package hu.bme.mit.mabel.examples.rdf.sesame.phases;

import java.io.File;
import java.io.IOException;

import org.openrdf.repository.RepositoryConnection;
import org.openrdf.rio.RDFFormat;

import hu.bme.mit.mabel.examples.rdf.phases.LoadPhase;

public class SesameLoadPhase extends LoadPhase<RepositoryConnection> {

	public SesameLoadPhase(final RepositoryConnection repositoryConnection, final String modelPath) {
		super(repositoryConnection, modelPath);
	}

	@Override
	public RepositoryConnection run() throws IOException {
		final File modelFile = new File(modelPath);
		databaseConnection.add(modelFile, null, RDFFormat.NTRIPLES);
		return databaseConnection;
	}

}

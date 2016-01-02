package hu.bme.mit.mabel.examples.rdf.phases;

import java.io.File;
import java.io.IOException;

import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;

import hu.bme.mit.mabel.engine.Phase;

public class LoadPhase implements Phase<RepositoryConnection> {

	final RepositoryConnection repositoryConnection;
	final String modelPath;

	public LoadPhase(final RepositoryConnection repositoryConnection, final String modelPath) {
		super();
		this.modelPath = modelPath;
		this.repositoryConnection = repositoryConnection;
	}

	@Override
	public RepositoryConnection run() throws RDFParseException, RepositoryException, IOException {
		final File modelFile = new File(modelPath);
		repositoryConnection.add(modelFile, null, RDFFormat.NTRIPLES);
		return repositoryConnection;
	}

	@Override
	public String getName() {
		return "Load";
	}

}

package hu.bme.mit.mabel.examples.rdf.jena.phases;

import java.io.IOException;

import org.apache.jena.rdf.model.Model;

import hu.bme.mit.mabel.examples.rdf.phases.LoadPhase;

public class JenaLoadPhase extends LoadPhase<Model> {

	public JenaLoadPhase(final Model model, final String modelPath) {
		super(model, modelPath);
	}

	@Override
	public Model run() throws IOException {
		final Model model = databaseConnection.read(modelPath);
		return model;
	}

}

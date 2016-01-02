package hu.bme.mit.mabel.examples.rdf.jena.phases;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import hu.bme.mit.mabel.examples.rdf.phases.InitPhase;

public class JenaInitPhase extends InitPhase<Model> {

	public JenaInitPhase() {
		super();
	}

	@Override
	public Model run() {
		final Model model = ModelFactory.createDefaultModel();
		return model;
	}

}

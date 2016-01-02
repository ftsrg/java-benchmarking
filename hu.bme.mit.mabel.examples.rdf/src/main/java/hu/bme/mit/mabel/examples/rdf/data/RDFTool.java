package hu.bme.mit.mabel.examples.rdf.data;

import hu.bme.mit.mabel.examples.rdf.jena.phases.JenaInitPhase;
import hu.bme.mit.mabel.examples.rdf.jena.phases.JenaLoadPhase;
import hu.bme.mit.mabel.examples.rdf.phases.InitPhase;
import hu.bme.mit.mabel.examples.rdf.phases.LoadPhase;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameInitPhase;
import hu.bme.mit.mabel.examples.rdf.sesame.phases.SesameLoadPhase;

public enum RDFTool {

	JENA, SESAME;

	public InitPhase<?> getInitPhase() {
		switch (this) {
		case JENA:
			return new JenaInitPhase();
		case SESAME:
			return new SesameInitPhase();
		default:
			throw new UnsupportedOperationException("Tool " + this.toString() + " not supported");
		}
	}

	public LoadPhase<?> getLoadPhase() {
		switch (this) {
		case JENA:
			return new JenaLoadPhase();
		case SESAME:
			return new SesameLoadPhase();
		default:
			throw new UnsupportedOperationException("Tool " + this.toString() + " not supported");
		}
	}

}

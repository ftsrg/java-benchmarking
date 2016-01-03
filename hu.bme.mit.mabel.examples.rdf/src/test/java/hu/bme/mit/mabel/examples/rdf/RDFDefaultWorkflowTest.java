package hu.bme.mit.mabel.examples.rdf;

import org.junit.Test;

import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;
import hu.bme.mit.mabel.examples.rdf.data.RDFTool;

public class RDFDefaultWorkflowTest {

	@Test
	public void testJena() {
		final RDFConfiguration configuration = new RDFConfiguration(2, true, "src/main/resources/infoboxproperties_en.nt", 2, RDFTool.JENA);
		RDFDefaultWorkflow.run(configuration);
	}

	@Test
	public void testSesame() {
		final RDFConfiguration configuration = new RDFConfiguration(2, true, "src/main/resources/infoboxproperties_en.nt", 2, RDFTool.SESAME);
		RDFDefaultWorkflow.run(configuration);
	}

}

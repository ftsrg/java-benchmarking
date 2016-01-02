package hu.bme.mit.mabel.examples.rdf;

import org.junit.Test;

import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;

public class RdfDefaultWorkflowTest {

	@Test
	public void test() {
		final RDFConfiguration configuration = new RDFConfiguration(2, true, "src/main/resources/infoboxproperties_en.nt", 10);
		RDFDefaultWorkflow.run(configuration);
	}

}

package hu.bme.mit.mabel.examples.rdf;

import java.io.IOException;

import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;

public class RDFBenchmark {

	public static void main(final String[] args) throws IOException, InterruptedException {
		final RDFConfiguration configuration = new RDFConfiguration(2, false, "src/main/resources/infoboxproperties_en.nt", 3);
		RDFDefaultWorkflow.spawn(configuration);
	}

}

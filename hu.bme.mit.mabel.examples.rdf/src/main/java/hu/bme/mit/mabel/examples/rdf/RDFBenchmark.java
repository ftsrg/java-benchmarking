package hu.bme.mit.mabel.examples.rdf;

import java.io.IOException;

import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;
import hu.bme.mit.mabel.examples.rdf.data.RDFTool;

public class RDFBenchmark {

	public static void main(final String[] args) throws IOException, InterruptedException {
		for (final RDFTool tool : RDFTool.values()) {
			final RDFConfiguration configuration = new RDFConfiguration(2, false, "src/main/resources/infoboxproperties_en.nt", 3, tool);
			RDFDefaultWorkflow.spawn(configuration);
		}
	}

}

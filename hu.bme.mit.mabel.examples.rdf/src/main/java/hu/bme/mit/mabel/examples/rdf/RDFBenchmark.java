package hu.bme.mit.mabel.examples.rdf;

import java.io.IOException;

import hu.bme.mit.mabel.examples.rdf.data.RDFConfiguration;
import hu.bme.mit.mabel.examples.rdf.data.RDFTool;

public class RDFBenchmark {

	public static void main(final String[] args) throws IOException, InterruptedException {
		for (final RDFTool tool : RDFTool.values()) {
			for (int modelSize = 1; modelSize <= 128; modelSize *= 2) {
				final RDFConfiguration configuration = new RDFConfiguration(5, false, modelSize, 25, tool);
				RDFDefaultWorkflow.spawn(configuration);
			}
		}
	}

}

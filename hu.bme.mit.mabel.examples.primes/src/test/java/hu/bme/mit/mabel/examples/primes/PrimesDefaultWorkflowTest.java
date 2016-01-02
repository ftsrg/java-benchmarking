package hu.bme.mit.mabel.examples.primes;

import org.junit.Test;

import hu.bme.mit.mabel.examples.primes.PrimesDefaultWorkflow;
import hu.bme.mit.mabel.examples.primes.data.PrimesConfiguration;

public class PrimesDefaultWorkflowTest {

	@Test
	public void test() {
		PrimesConfiguration configuration = new PrimesConfiguration(2, true, 1, 128, 256);
		PrimesDefaultWorkflow.run(configuration);
	}

}

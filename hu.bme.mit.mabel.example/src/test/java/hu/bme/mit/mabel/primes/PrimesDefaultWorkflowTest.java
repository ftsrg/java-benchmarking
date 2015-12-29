package hu.bme.mit.mabel.primes;

import org.junit.Test;

import hu.bme.mit.mabel.primes.data.PrimesConfiguration;

public class PrimesDefaultWorkflowTest {

	@Test
	public void test() {
		PrimesConfiguration configuration = new PrimesConfiguration(1, true, 1, 128, 256);
		PrimesDefaultWorkflow.run(configuration);
	}

}

package hu.bme.mit.mabel.examples.primes;

import java.io.IOException;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;

import hu.bme.mit.mabel.data.ExecutionId;
import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.engine.WorkflowRunner;
import hu.bme.mit.mabel.examples.primes.data.PrimesConfiguration;
import hu.bme.mit.mabel.examples.primes.phases.CombinationPhase;
import hu.bme.mit.mabel.examples.primes.phases.FactorizationPhase;
import hu.bme.mit.mabel.examples.primes.phases.GenerationPhase;
import hu.bme.mit.mabel.examples.primes.phases.TestPhase;

public class PrimesDefaultWorkflow {

	public static void run(final PrimesConfiguration configuration) {
		final Results results = new Results();
		for (int run = 1; run <= configuration.getRuns(); run++) {
			ExecutionId executionId = new ExecutionId(run);
			final List<Integer> primes = PhaseRunner.run(new GenerationPhase(configuration), executionId, results);
			final List<Long> combined = PhaseRunner.run(new CombinationPhase(primes), executionId, results);
			final List<Integer> factors = PhaseRunner.run(new FactorizationPhase(combined, configuration), executionId, results);
			PhaseRunner.run(new TestPhase(primes, factors), executionId, results);
		}
		System.out.print(results);
	}

	public static void spawn(PrimesConfiguration configuration) throws IOException, InterruptedException {
		WorkflowRunner.spawn(PrimesDefaultWorkflow.class, configuration);
	}

	public static void main(final String[] args) throws CmdLineException {
		final PrimesConfiguration configuration = PrimesConfiguration.parse(args);
		run(configuration);
	}

}

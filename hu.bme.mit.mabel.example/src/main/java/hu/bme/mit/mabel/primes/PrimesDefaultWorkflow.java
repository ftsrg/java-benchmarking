package hu.bme.mit.mabel.primes;

import java.io.IOException;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;

import hu.bme.mit.mabel.data.Results;
import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.engine.WorkflowRunner;
import hu.bme.mit.mabel.primes.data.PrimesConfiguration;
import hu.bme.mit.mabel.primes.phases.CombinationPhase;
import hu.bme.mit.mabel.primes.phases.FactorizationPhase;
import hu.bme.mit.mabel.primes.phases.GenerationPhase;
import hu.bme.mit.mabel.primes.phases.TestPhase;

public class PrimesDefaultWorkflow {

	public static void run(final PrimesConfiguration configuration) {
		final Results results = new Results();
		for (int run = 1; run <= configuration.getRuns(); run++) {
			final List<Integer> primes = PhaseRunner.run(new GenerationPhase(configuration), run, results);
			final List<Long> combined = PhaseRunner.run(new CombinationPhase(primes), run, results);
			final List<Integer> factors = PhaseRunner.run(new FactorizationPhase(combined, configuration), run, results);
			PhaseRunner.run(new TestPhase(primes, factors), run, results);
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

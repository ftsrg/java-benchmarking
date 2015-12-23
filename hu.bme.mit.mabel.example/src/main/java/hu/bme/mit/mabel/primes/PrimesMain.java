package hu.bme.mit.mabel.primes;

import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.primes.data.PrimesConfiguration;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;
import hu.bme.mit.mabel.primes.data.PrimesPayload;
import hu.bme.mit.mabel.primes.data.PrimesResults;
import hu.bme.mit.mabel.primes.phases.CombinationPhase;
import hu.bme.mit.mabel.primes.phases.FactorizationPhase;
import hu.bme.mit.mabel.primes.phases.GenerationPhase;
import hu.bme.mit.mabel.primes.phases.TestPhase;

public class PrimesMain {

	public static void main(final String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: app <runs>");
			return;
		}

		final int runs = Integer.parseInt(args[0]);
		final boolean verbose = false;
		// final int max = Integer.MAX_VALUE;
		final int max = 1000;
		final int min = max / 2;
		final int numberOfCompositeNumbers = 1;

		final PrimesConfiguration configuration = new PrimesConfiguration(runs, verbose, numberOfCompositeNumbers, min, max);

		final PrimesResults results = new PrimesResults();
		for (int run = 1; run <= configuration.getRuns(); run++) {
			final PrimesPayload data = PrimesPayload.create(configuration);
			final PrimesDataToken dataToken0 = new PrimesDataToken(configuration, data, results);

			// generation
			final GenerationPhase generationPhase = new GenerationPhase(dataToken0);
			final PhaseRunner<GenerationPhase, PrimesDataToken> generationRunner = new PhaseRunner<>(generationPhase);
			generationRunner.run();
			final PrimesDataToken dataToken1 = generationPhase.getDataToken();

			// combination
			final CombinationPhase combinationPhase = new CombinationPhase(dataToken1);
			final PhaseRunner<CombinationPhase, PrimesDataToken> combinationRunner = new PhaseRunner<>(combinationPhase);
			combinationRunner.run();
			final PrimesDataToken dataToken2 = generationPhase.getDataToken();

			// factorization
			final FactorizationPhase factorizationPhase = new FactorizationPhase(dataToken2);
			final PhaseRunner<FactorizationPhase, PrimesDataToken> factorizationRunner = new PhaseRunner<>(factorizationPhase);
			factorizationRunner.run();
			final PrimesDataToken dataToken3 = generationPhase.getDataToken();

			// test
			final TestPhase testPhase = new TestPhase(dataToken3);
			final PhaseRunner<TestPhase, PrimesDataToken> testRunner = new PhaseRunner<>(testPhase);
			testRunner.run();
		}
		System.out.print(results);
	}

}

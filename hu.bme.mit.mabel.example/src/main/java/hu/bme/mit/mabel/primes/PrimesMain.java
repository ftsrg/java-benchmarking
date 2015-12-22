package hu.bme.mit.mabel.primes;

import java.io.IOException;

import hu.bme.mit.mabel.engine.PhaseRunner;
import hu.bme.mit.mabel.primes.data.PrimesConfiguration;
import hu.bme.mit.mabel.primes.data.PrimesData;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;
import hu.bme.mit.mabel.primes.data.PrimesResults;
import hu.bme.mit.mabel.primes.phases.CombinationPhase;
import hu.bme.mit.mabel.primes.phases.FactorizationPhase;
import hu.bme.mit.mabel.primes.phases.GenerationPhase;

public class PrimesMain {

	public static void main(final String[] args) throws IOException, InstantiationException, IllegalAccessException {
		if (args.length < 1) {
			System.out.println("Usage: app <runs>");
			return;
		}

		final int runs = Integer.parseInt(args[0]);

		for (int run = 1; run <= runs; run++) {
			final PrimesConfiguration configuration = new PrimesConfiguration(1, Integer.MAX_VALUE / 2, Integer.MAX_VALUE);
			final PrimesData data = PrimesData.create(configuration);
			final PrimesResults results = new PrimesResults();
			final PrimesDataToken dataToken1 = new PrimesDataToken(configuration, data, results);

			// generation
			final GenerationPhase generationPhase = new GenerationPhase(dataToken1);
			final PhaseRunner<GenerationPhase, PrimesDataToken> generationRunner = new PhaseRunner<>(generationPhase);
			generationRunner.run();
			final PrimesDataToken dataToken2 = generationPhase.getDataToken();

			// combination
			final CombinationPhase combinationPhase = new CombinationPhase(dataToken2);
			final PhaseRunner<CombinationPhase, PrimesDataToken> combinationRunner = new PhaseRunner<>(combinationPhase);
			combinationRunner.run();
			final PrimesDataToken dataToken3 = generationPhase.getDataToken();

			// factorization
			final FactorizationPhase factorizationPhase = new FactorizationPhase(dataToken3);
			final PhaseRunner<FactorizationPhase, PrimesDataToken> factorizationRunner = new PhaseRunner<>(factorizationPhase);
			factorizationRunner.run();

		}
	}

}

package hu.bme.mit.mabel.primes;

import java.io.IOException;

import hu.bme.mit.mabel.engine.PhaseRunner;

public class PrimesMain {

	public static void main(final String[] args) throws IOException, InstantiationException, IllegalAccessException {
		if (args.length < 1) {
			System.out.println("Usage: app <runs>");
			return;
		}

		final int runs = Integer.parseInt(args[0]);

		for (int run = 1; run <= runs; run++) {		
			final PrimesDataToken token = PrimesDataToken.create(100);
			
			final PhaseRunner primeGenerator = PhaseRunner.newInstance(PrimeGeneratorPhase.class, token);
			final PhaseRunner primeCombiner = PhaseRunner.newInstance(PrimeCombinerPhase.class, token);

			primeGenerator.run();
			primeCombiner.run();
		}
	}

}

package hu.bme.mit.mabel.examples.primes.phases;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.engine.BenchmarkUtils;
import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.examples.primes.data.PrimesConfiguration;

public class FactorizationPhase implements Phase<List<Integer>> {

	private final List<Long> combined;
	private final PrimesConfiguration configuration;

	public FactorizationPhase(final PrimesConfiguration configuration, final List<Long> combined) {
		this.combined = combined;
		this.configuration = configuration;
	}

	@Override
	public List<Integer> run() {
		final List<Integer> result = new ArrayList<>();
		for (final Long x : combined) {
			final List<Integer> factors = factors(configuration, x);
			result.addAll(factors);
		}
		return result;
	}

	private static List<Integer> factors(final PrimesConfiguration configuration, final Long x) {
		final List<Integer> factors = new ArrayList<Integer>();

		Long n = x;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}

		BenchmarkUtils.log("Factors: " + factors, configuration);
		return factors;
	}

	@Override
	public String getName() {
		return "Factorize";
	}

}

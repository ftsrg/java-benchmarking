package hu.bme.mit.mabel.primes.phases;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.engine.BenchmarkUtils;
import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.primes.data.PrimesConfiguration;

public class FactorizationPhase implements Phase<List<Integer>> {

	private final List<Long> combined;
	private final PrimesConfiguration configuration;

	public FactorizationPhase(List<Long> combined, PrimesConfiguration configuration) {
		this.combined = combined;
		this.configuration = configuration;
	}

	public List<Integer> run() {
		List<Integer> result = new ArrayList<>();
		for (final Long x : combined) {
			final List<Integer> factors = factors(x, configuration);
			result.addAll(factors);
		}
		return result;
	}

	private static List<Integer> factors(Long x, PrimesConfiguration configuration) {
		final List<Integer> factors = new ArrayList<Integer>();

		for (int i = 2; i <= x; i++) {
			while (x % i == 0) {
				factors.add(i);
				x /= i;
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

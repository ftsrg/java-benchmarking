package hu.bme.mit.mabel.primes.data;

import hu.bme.mit.mabel.engine.DataToken;

public class PrimesDataToken extends DataToken<PrimesConfiguration, PrimesData, PrimesResults> {

	public PrimesDataToken(final PrimesConfiguration configuration, final PrimesData data, final PrimesResults results) {
		super(configuration, data, results);
	}
	
}

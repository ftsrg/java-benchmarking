package hu.bme.mit.mabel.primes.data;

import hu.bme.mit.mabel.data.DataToken;

public class PrimesDataToken extends DataToken<PrimesConfiguration, PrimesPayload, PrimesResults> {

	public PrimesDataToken(final PrimesConfiguration configuration, final PrimesPayload payload, final PrimesResults results) {
		super(configuration, payload, results);
	}
	
}

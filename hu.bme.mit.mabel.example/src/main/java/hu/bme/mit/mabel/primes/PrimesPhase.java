package hu.bme.mit.mabel.primes;

import hu.bme.mit.mabel.engine.Phase;
import hu.bme.mit.mabel.primes.data.PrimesDataToken;

public abstract class PrimesPhase extends Phase<PrimesDataToken> {

	public PrimesPhase(final PrimesDataToken dataToken) {
		super(dataToken);
	}

}

package hu.bme.mit.mabel.primes;

import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.mabel.engine.DataToken;

public class PrimesDataToken extends DataToken {

	protected int n;
	protected List<Long> primes;
	protected List<Long> combined;

	protected PrimesDataToken(final int n) {
		super();
		this.n = n;
		primes = new ArrayList<>(n);
		combined = new ArrayList<>(n / 2);
	}

	public static PrimesDataToken create(final int n) {
		return new PrimesDataToken(n);
	}

	public List<Long> getPrimes() {
		return primes;
	}

	public List<Long> getCombined() {
		return combined;
	}

	public int getN() {
		return n;
	}

}

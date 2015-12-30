package hu.bme.mit.mabel.data;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

import hu.bme.mit.mabel.engine.Phase;

public class ExecutionId {

	private final int run;
	private final List<Integer> phaseInstanceId;

	public ExecutionId(int run, List<Integer> phaseInstanceId) {
		this.run = run;
		this.phaseInstanceId = phaseInstanceId;
	}
	
	public ExecutionId(int run, Integer... phaseInstanceId) {
		this(run, Arrays.asList(phaseInstanceId));
	}

	public int getRun() {
		return run;
	}

	public List<Integer> getPhaseInstanceId() {
		return phaseInstanceId;
	}

	public String getPhaseInstanceIdString() {
		return Joiner.on('.').join(phaseInstanceId);
	}

}

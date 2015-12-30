package hu.bme.mit.mabel.data;

import java.util.List;

import com.google.common.base.Joiner;

public class ExecutionId {

	private final int run;
	private final List<Integer> phaseInstanceId;

	public ExecutionId(int run, List<Integer> phaseInstanceId) {
		this.run = run;
		this.phaseInstanceId = phaseInstanceId;
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

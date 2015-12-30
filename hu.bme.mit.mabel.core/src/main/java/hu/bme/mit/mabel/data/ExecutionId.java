package hu.bme.mit.mabel.data;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

import hu.bme.mit.mabel.engine.Phase;

/**
 * Uniquely identifies the execution of a {@link Phase}.
 */
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

	/**
	 * The index of the execution of the whole workflow.
	 */
	public int getRun() {
		return run;
	}

	/**
	 * Identifies the execution among multiple executions of the same {@link Phase} in a workflow.
	 * It is hierarchical, so it can be used for arbitrary nested loops.
	 */
	public List<Integer> getPhaseInstanceId() {
		return phaseInstanceId;
	}
	
	/**
	 * Returns the {@link String} representation of {@link #getPhaseInstanceId()}.
	 */
	public String getPhaseInstanceIdString() {
		return Joiner.on('.').join(phaseInstanceId);
	}

}

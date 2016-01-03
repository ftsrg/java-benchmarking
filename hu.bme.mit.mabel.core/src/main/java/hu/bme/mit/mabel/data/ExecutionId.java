package hu.bme.mit.mabel.data;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

import hu.bme.mit.mabel.engine.Phase;

/**
 * Uniquely identifies the execution of a {@link Phase}.
 */
public class ExecutionId {

	private final String subject;
	private final int run;
	private final List<Integer> phaseInstanceId;

	public ExecutionId(final String subject, final int run, final List<Integer> phaseInstanceId) {
		this.subject = subject;
		this.run = run;
		this.phaseInstanceId = phaseInstanceId;
	}

	public ExecutionId(final String subject, final int run, final Integer... phaseInstanceId) {
		this(subject, run, Arrays.asList(phaseInstanceId));
	}

	/**
	 * The subject of the benchmark, e.g. the tool or the algorithm under benchmark.
	 */
	public String getSubject() {
		return subject;
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

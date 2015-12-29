package hu.bme.mit.mabel.engine;

public interface Phase<Value> {

	Value run();

	String getName();
	
}

package hu.bme.mit.mabel.examples.rdf.data;

public enum RDFTool {
	JENA("Jena"),
	SESAME("Sesame");

	private String name;

	RDFTool(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}

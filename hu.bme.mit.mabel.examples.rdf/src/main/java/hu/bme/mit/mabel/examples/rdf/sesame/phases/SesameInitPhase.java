package hu.bme.mit.mabel.examples.rdf.sesame.phases;

import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.memory.MemoryStore;

import hu.bme.mit.mabel.examples.rdf.phases.InitPhase;

public class SesameInitPhase extends InitPhase<RepositoryConnection> {

	public SesameInitPhase() {
		super();
	}

	@Override
	public RepositoryConnection run() {
		final Repository repository = new SailRepository(new MemoryStore());
		repository.initialize();
		final RepositoryConnection repositoryConnection = repository.getConnection();
		return repositoryConnection;
	}

}

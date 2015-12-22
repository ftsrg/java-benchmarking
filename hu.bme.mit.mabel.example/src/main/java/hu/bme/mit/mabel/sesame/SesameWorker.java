package hu.bme.mit.mabel.sesame;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.sail.memory.MemoryStore;

import com.google.common.base.Stopwatch;

public class SesameWorker {

	public void work(final String vmargs, final int run) throws IOException {
		final File modelFile = new File("src/main/resources/infoboxproperties_en.nt");
		final String query = "SELECT (COUNT(*) AS ?count) WHERE {?s ?p ?o}";

		// init
		final Stopwatch stopwatchInit = Stopwatch.createStarted();

		final Repository repository = new SailRepository(new MemoryStore());
		repository.initialize();
		final RepositoryConnection connection = repository.getConnection();

		final long elapsedInit = stopwatchInit.elapsed(TimeUnit.NANOSECONDS);
		System.out.println(String.format("%s,%d,Init,%d", vmargs, run, elapsedInit));


		// load
		final Stopwatch stopwatchLoad = Stopwatch.createStarted();
		connection.add(modelFile, null, RDFFormat.NTRIPLES);
		final long elapsedLoad = stopwatchLoad.elapsed(TimeUnit.NANOSECONDS);
		System.out.println(String.format("%s,%d,Load,%d", vmargs, run, elapsedLoad));

		
		// query
		final Stopwatch stopwatchQuery= Stopwatch.createStarted();
		final TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, query);
		try (TupleQueryResult queryResults = tupleQuery.evaluate()) {
			while (queryResults.hasNext()) {
				final BindingSet bs = queryResults.next();
			}
		}
		final long elapsedQuery = stopwatchQuery.elapsed(TimeUnit.NANOSECONDS);
		System.out.println(String.format("%s,%d,Query,%d", vmargs, run, elapsedQuery));

		connection.close();
	}

}

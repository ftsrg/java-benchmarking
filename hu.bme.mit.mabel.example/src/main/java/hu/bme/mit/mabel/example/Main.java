package hu.bme.mit.mabel.example;

import java.io.IOException;

public class Main {

	public static void main(final String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Usage: app <vmargs> <runs>");
			return;
		}

		final String vmargs = args[0];
		final int runs = Integer.parseInt(args[1]);

		for (int i = 1; i <= runs; i++) {
			final Worker worker = new Worker();
			worker.work(vmargs, i);
		}
	}

}

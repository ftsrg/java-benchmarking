package hu.bme.mit.mabel.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.NamedOptionDef;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.BooleanOptionHandler;
import org.kohsuke.args4j.spi.OptionHandler;

import hu.bme.mit.mabel.data.Configuration;

public class WorkflowRunner {

	/**
	 * Runs the <code>main</code> method of the given workflow {@link Class} with the given {@link Configuration}
	 * in a separate JVM process.
	 */
	public static void spawn(final Class<?> workflowClass, final Configuration configuration) throws IOException, InterruptedException {
		final List<String> command = new ArrayList<>();
		command.add("java");

		for (final String jvmArgument : configuration.getJvmArguments()) {
			command.add(jvmArgument);
		}

		command.add("-cp");
		final String classPath = getJarPath(workflowClass);
		command.add(classPath);

		final String mainClassName = workflowClass.getName();
		command.add(mainClassName);

		final List<String> args = getCommandLineArguments(configuration);
		command.addAll(args);

		final ProcessBuilder processBuilder = new ProcessBuilder(command).inheritIO();
		final Process process = processBuilder.start();
		process.waitFor();
	}

	private static String getJarPath(final Class<?> workflowClass) throws IOException {
		final Properties properties = new Properties();
		final InputStream stream = workflowClass.getClassLoader().getResourceAsStream("maven.properties");
		properties.load(stream);
		final String jarPath = properties.getProperty("jar.path");
		return jarPath;
	}

	private static List<String> getCommandLineArguments(final Configuration configuration) {
		final List<String> result = new ArrayList<>();
		final CmdLineParser parser = new CmdLineParser(configuration);
		for (final OptionHandler<?> optionHandler : parser.getOptions()) {
			final OptionDef option = optionHandler.option;
			if (option instanceof NamedOptionDef) {
				final NamedOptionDef namedOption = (NamedOptionDef) option;
				final Object value = optionHandler.setter.asFieldSetter().getValue();
				if (optionHandler instanceof BooleanOptionHandler) {
					if (value == Boolean.TRUE) {
						result.add(namedOption.name());
					}
				} else {
					result.add(namedOption.name());
					result.add(value.toString());
				}
			}
		}
		return result;
	}

}

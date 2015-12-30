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
	public static void spawn(Class<?> workflowClass, Configuration configuration) throws IOException, InterruptedException {
		List<String> command = new ArrayList<>();
		command.add("java");

		command.add("-cp");
		String classPath = getJarPath(workflowClass);
		command.add(classPath);

		String mainClassName = workflowClass.getName();
		command.add(mainClassName);

		List<String> args = getCommandLineArguments(configuration);
		command.addAll(args);

		ProcessBuilder processBuilder = new ProcessBuilder(command).inheritIO();
		Process process = processBuilder.start();
		process.waitFor();
	}

	private static String getJarPath(Class<?> workflowClass) throws IOException {
		final Properties properties = new Properties();
		final InputStream stream = workflowClass.getClassLoader().getResourceAsStream("maven.properties");
		properties.load(stream);
		String jarPath = properties.getProperty("jar.path");
		return jarPath;
	}

	private static List<String> getCommandLineArguments(Configuration configuration) {
		List<String> result = new ArrayList<>();
		CmdLineParser parser = new CmdLineParser(configuration);
		for (OptionHandler<?> optionHandler : parser.getOptions()) {
			OptionDef option = optionHandler.option;
			if (option instanceof NamedOptionDef) {
				NamedOptionDef namedOption = (NamedOptionDef) option;
				Object value = optionHandler.setter.asFieldSetter().getValue();
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

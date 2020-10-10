/**
 * 
 */
package jiangduochen;

import java.util.Optional;

import javax.inject.Inject;

import jiangduochen.command.Command;
import jiangduochen.command.parser.CommandParser;
import jiangduochen.command.parser.CommandParserRepository;
import jiangduochen.console.Console;
import org.springframework.stereotype.Service;

@Service
public class SocialNetwork {

	@Inject
	private Console console;

	@Inject
	private CommandParserRepository parserRepository;

	public void start() {
		String line;
		while ((line = console.readCommand()) != null) {
			parseAndExecuteCommand(line);
		}

		console.write("bye");
	}

	private void parseAndExecuteCommand(String line) {
		Optional<CommandParser> parser = parserRepository.findParser(line);
		if (parser.isPresent()) {
			Command command = parser.get().parse(line);
			command.execute(console);
		} else {
			console.write("Unknown command: " + line);
		}
	}
}

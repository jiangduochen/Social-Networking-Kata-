/**
 * 
 */
package jiangduochen.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import jiangduochen.command.Command;
import jiangduochen.command.PostCommand;
import jiangduochen.user.User;
import jiangduochen.user.UserRepository;


@Component
public class PostCommandParser implements CommandParser {
	
	private static final String POST_PATTERN = "^(?<name>[^\\s]*) -> (?<message>.*)$";
	
	@Inject
	private UserRepository users;

	@Override
	public boolean canHandle(String line) {
		return line.matches(POST_PATTERN);
	}

	@Override
	public Command parse(String line) {
		Matcher matcher = Pattern.compile(POST_PATTERN).matcher(line);
		
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Unparsable line " + line);
		}
		
		String name = matcher.group("name");
		String message = matcher.group("message");
		
		User user = users.getOrCreate(name);
		
		PostCommand command = new PostCommand(user, message);
		return command;
	}
}

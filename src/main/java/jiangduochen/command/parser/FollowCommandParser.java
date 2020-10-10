/**
 * 
 */
package jiangduochen.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import jiangduochen.command.Command;
import jiangduochen.command.FollowCommand;
import jiangduochen.user.User;
import jiangduochen.user.UserRepository;


@Component
public class FollowCommandParser implements CommandParser {

	private static final String FOLLOW_PATTERN = "^(?<name>[^\\s]*) follows (?<friend>[^\\s]*)$";

	@Inject
	private UserRepository users;

	@Override
	public boolean canHandle(String line) {
		return line.matches(FOLLOW_PATTERN);
	}

	@Override
	public Command parse(String line) {
		Matcher matcher = Pattern.compile(FOLLOW_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("Unparsable line " + line);
		}

		String userName = matcher.group("name");
		String friendName = matcher.group("friend");

		User user = users.getOrCreate(userName);
		User friend = users.getOrCreate(friendName);

		FollowCommand command = new FollowCommand(user, friend);
		return command;
	}
}

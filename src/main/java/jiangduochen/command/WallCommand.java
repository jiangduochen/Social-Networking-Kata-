/**
 * 
 */
package jiangduochen.command;

import java.util.List;

import jiangduochen.console.Console;
import jiangduochen.user.Message;
import jiangduochen.user.User;


public class WallCommand implements Command {
	
	private User user;

	public User getUser() {
		return user;
	}

	public WallCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute(Console console) {
		List<Message> wall = user.getWall();
		
		for (Message message : wall) {
			console.write(message);
		}
	}
}

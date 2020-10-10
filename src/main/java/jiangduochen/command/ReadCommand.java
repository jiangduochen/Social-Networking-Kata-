/**
 * 
 */
package jiangduochen.command;

import jiangduochen.console.Console;
import jiangduochen.user.Message;
import jiangduochen.user.User;


public class ReadCommand implements Command {
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public ReadCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute(Console console) {
		for (Message message : user.getMessages()) {
			console.write(message);
		}
	}

}

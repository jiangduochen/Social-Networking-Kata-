/**
 * 
 */
package jiangduochen.command;

import jiangduochen.console.Console;
import jiangduochen.user.User;

public class FollowCommand implements Command {
	
	private User user;
	private User friend;
	
	public User getUser() {
		return user;
	}

	public User getFriend() {
		return friend;
	}

	public FollowCommand(User user, User friend) {
		this.user = user;
		this.friend = friend;
	}

	@Override
	public void execute(Console console) {
		user.addFriend(friend);
	}

}

/**
 * 
 */
package jiangduochen.command;

import java.time.ZonedDateTime;

import jiangduochen.console.Console;
import jiangduochen.user.Message;
import jiangduochen.user.User;

public class PostCommand implements Command {
	
	private User author;
	private String text;
	
	public User getAuthor() {
		return author;
	}

	public String getText() {
		return text;
	}

	public PostCommand(User author, String text) {
		this.author = author;
		this.text = text;
	}

	@Override
	public void execute(Console console) {
		Message message = new Message(author, ZonedDateTime.now(), text);
		author.postMessage(message);
	}
}

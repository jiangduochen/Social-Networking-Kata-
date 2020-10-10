/**
 * 
 */
package jiangduochen.command;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import jiangduochen.console.Console;
import jiangduochen.user.Message;
import jiangduochen.user.User;


@RunWith(MockitoJUnitRunner.class)
public class PostCommandTest {
	
	private PostCommand command;
	private User author;
	private String text;
	private Console console;

	@Before
	public void setUp() throws Exception {
		author = new User("MyUser");
		text = "Hello";
		
		command = new PostCommand(author, text);
		
		console = mock(Console.class);
	}

	@Test
	public void testExecute() {
		command.execute(console);
		
		List<Message> messages = author.getMessages();
		assertTrue(messages.stream().anyMatch(m -> m.getText().equals(text)));
	}

}

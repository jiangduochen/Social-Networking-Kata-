package jiangduochen.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import jiangduochen.console.Console;
import jiangduochen.user.Message;
import jiangduochen.user.User;


@RunWith(MockitoJUnitRunner.class)
public class WallCommandTest {
	
	private ReadCommand command;
	private User user;
	private Console console;

	@Before
	public void setUp() throws Exception {
		user = new User("MyUser");
		
		command = new ReadCommand(user);
		
		console = mock(Console.class);
	}
	
	@Test
	public void testExecuteWithUserMessage() {
		Message message = new Message(user, ZonedDateTime.now(), "Hello");
		user.postMessage(message);
		
		command.execute(console);
		
		verify(console).write(message);
	}

	@Test
	public void testExecuteEmptyWall() {
		command.execute(console);
		
		verifyZeroInteractions(console);
	}

}

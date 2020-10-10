package jiangduochen.command;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import jiangduochen.console.Console;
import jiangduochen.user.User;


@RunWith(MockitoJUnitRunner.class)
public class FollowCommandTest {

	private FollowCommand command;
	private User user;
	private User friend;
	private Console console;
	
	@Before
	public void setup() {
		user = new User("MyUser");
		friend = new User("Friend");
		
		command = new FollowCommand(user, friend);
		
		console = mock(Console.class);
	}
	
	@Test
	public void testExecute() {
		command.execute(console);
		
		assertTrue(user.getFriends().contains(friend));
	}

}

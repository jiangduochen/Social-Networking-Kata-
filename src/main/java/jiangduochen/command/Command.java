/**
 * 
 */
package jiangduochen.command;

import jiangduochen.console.Console;

public interface Command {

	/**
	 * Executes the command using the passed {@link Console}.
	 * @param console
	 */
	void execute(Console console);
}

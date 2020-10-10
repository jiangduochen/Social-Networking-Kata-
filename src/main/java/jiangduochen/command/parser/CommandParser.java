/**
 * 
 */
package jiangduochen.command.parser;

import jiangduochen.command.Command;


public interface CommandParser {
	
	public boolean canHandle(String line);
	
	public Command parse(String line);

}

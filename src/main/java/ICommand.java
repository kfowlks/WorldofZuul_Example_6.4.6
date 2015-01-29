
public interface ICommand {
	
	/**
	 *  Executes a specific logic for each class that implements this interface.
	 *  
	 * @param command
	 * @return a boolean is returned to indicate the user should terminate the program.
	 */
	public boolean execute(Command command);
}

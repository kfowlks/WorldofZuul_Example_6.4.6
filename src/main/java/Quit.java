
public class Quit extends CommandWords implements ICommand {

	@Override
	public boolean execute(Command command) {

		if(command.hasSecondWord()) {
           System.out.println("Quit what?");
           return false;
        }
        else {
            return true;  // signal that we want to quit
        }
	}

}

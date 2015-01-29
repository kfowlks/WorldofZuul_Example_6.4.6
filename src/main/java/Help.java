
public class Help extends CommandWords implements ICommand {
	
	public boolean execute(Command command)
    {
		  
		  System.out.println("You are lost. You are alone. You wander");
          System.out.println("around at the university.");
	      System.out.println();
	      System.out.println("Your command words are:");
		  
		  super.showAll();
		  
		  return false;
    }
}

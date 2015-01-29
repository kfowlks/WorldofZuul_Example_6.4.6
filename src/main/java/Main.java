import java.util.ArrayList;

/**
 * This class provide a functional example of abstracting a switch/if...else statement and delegating those functions to the
 * respective implementation class. This class is provided to serve as an example of how to implement a solution to exercise
 * 6.4.6 in the BlueJ 5th edition book. 
 * 
 * 
 * @author Kevin Fowlks
 * 
 */
public class Main {

	private Parser parser;
    
    private final int MAXWEIGHT = 10;       // max weight of items on inventory
	        
	    /**
	     * Create the game and initialise its internal map.
	     */
    public Main() 
    {
        parser = new Parser();
    }
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.play();
	}
	
	 /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        
    }
	
	
	/**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        boolean debug      = false;
        
        Class classz = null;
        ICommand cmd = null;
        
        if( command.isUnknown() ) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if( debug )
        {
	        System.out.println("getCanonicalName: " + Quit.class.getCanonicalName());
	        System.out.println("getName: " + Quit.class.getName());
	        System.out.println("getSimpleName: " + Quit.class.getSimpleName());
        }
        
        String commandWord = command.getCommandWord();
        
        /* Builds a string that represents the class name e.g. quit becomes Quit ..etc*/
        commandWord = commandWord.substring(0,1).toUpperCase() + commandWord.substring(1);

        if( debug )
        	System.out.println(" This string should match the class name: " + commandWord);
        
        try {
			classz = Class.forName( commandWord );
			cmd = (ICommand) classz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        if( cmd == null || !(cmd instanceof ICommand) ) 
        {
        	System.out.println("I don't know what you mean...");
        	return false;
        }
        
        wantToQuit = cmd.execute(command);
        
        /* The above code replaces the old way of calling a command via a switch or if...else statements. - Kevin 
        if (commandWord.equals("help")) {
          printHelp();
          }
        else if (commandWord.equals("quit")) 
        {
        	wantToQuit = quit(command);
        }                
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("inventory")) {
            printInventory();
        } else if (commandWord.equals("take")) {
            doTake(command);
        } else if (commandWord.equals("drop")) {
            doDrop(command);
        } else if (commandWord.equals("look")) {
            System.out.println(currentRoom.getLongDescription());
        }
        */
        
        return wantToQuit;
    }
	
}

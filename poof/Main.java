package poof;
import poof.textui.main.MainEdit;
import poof.core.Shell ;


import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
 * Forms editor application: allows the creation and manipulation of
 * graphical forms such as squares, circles, and lines.
 * Forms can be created, moved, and deleted.
 * 
 * @author Programação com Objectos
 * @version 3.0
 */
public class Main {

    /**
     * @param args command line arguments.
     */
    public static void main(String args[]) {
    Shell system= new Shell();
	Menu menu = new MainEdit(system);
	menu.open();
	IO.close();
	
    }
}

package poof.textui.main;

import poof.core.Shell;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
 * Forms editor application: allows the creation and manipulation of
 * graphical forms such as squares, circles, and lines.
 * Forms can be created, moved, and deleted. The options for draw the forms,
 * moving and removing a form are only visible if the editor has at least one
 * form.
 * 
 * @author Programação com Objectos
 * @version 3.0
 */
public class MainEdit extends Menu {

    /**
     * Constructor
     */
    public MainEdit(Shell system) {
	super(poof.textui.main.MenuEntry.TITLE, new Command<?>[] {
		new poof.textui.main.commands.New(system),
			new poof.textui.main.commands.Open(system),
			new poof.textui.main.commands.Save(system),
			new poof.textui.main.commands.Login(system),
			new poof.textui.main.commands.Menu_Shell(system),
			new poof.textui.main.commands.Menu_User(system),

				
		    });

		entry(2).invisible();
		entry(3).invisible();
		entry(4).invisible();
		entry(5).invisible();
		
    }
     /**
     * Show the options move, draw and erase. These options should not be shown when the editor
     * is empty.
     **/
    public void showOptionsNonEmptyEditor() {
	entry(2).visible();
	entry(3).visible();
	entry(4).visible();
	entry(5).visible();
    }

     public void hideOptionsEmptyEditor() {
	entry(0).invisible();
	
    }

}
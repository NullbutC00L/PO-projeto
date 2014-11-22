package poof.textui.user;

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
public class UserEdit extends Menu {

    /**
     * Constructor
     */
    public UserEdit(Shell system) {
	super(poof.textui.user.MenuEntry.TITLE, new Command<?>[] {
		new poof.textui.user.commands.CreateUser(system),
		new poof.textui.user.commands.ListUsers(system),
		

				
		    });
    }

}
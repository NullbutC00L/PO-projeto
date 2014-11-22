package poof.textui.shell;

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
public class ShellEdit extends Menu {

    /**
     * Constructor
     */
    public ShellEdit(Shell system) {
	super(poof.textui.shell.MenuEntry.TITLE, new Command<?>[] {
		new poof.textui.shell.commands.Ls(system), 
		new poof.textui.shell.commands.LsEntry(system),
		new poof.textui.shell.commands.Rm(system), 
		new poof.textui.shell.commands.Cd(system),
		new poof.textui.shell.commands.Touch(system),
		new poof.textui.shell.commands.Mkdir(system),
		
		new poof.textui.shell.commands.Pwd(system),
		
		new poof.textui.shell.commands.Append(system),
		new poof.textui.shell.commands.Cat(system),
		new poof.textui.shell.commands.Chmod(system),
		new poof.textui.shell.commands.Chown(system),
		

				
		    });
    }

}
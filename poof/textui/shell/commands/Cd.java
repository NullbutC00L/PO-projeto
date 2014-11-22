package poof.textui.shell.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;
import poof.textui.shell.MenuEntry;

import poof.textui.shell.ShellEdit;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para mudar o directório de trabalho.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Cd extends Command<Shell> {
    
    public Cd(Shell system) {
	super(MenuEntry.CD, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
     

       
        

        
    }
}

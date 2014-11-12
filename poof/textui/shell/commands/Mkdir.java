package poof.textui.shell.commands;


import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import poof.core.FileSystem;
import poof.core.Shell;
import poof.textui.shell.MenuEntry;

import poof.textui.shell.ShellEdit;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para criar um novo directorio.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Mkdir extends Command<Shell> {
    
    public Mkdir(Shell system) {
	super(MenuEntry.MKDIR, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

    	Form f = new Form(title());
        
    	InputString file = new InputString(f,"Dir Name");
    	f.parse();

    	entity().getFileSystem().makeDir(file.toString());

     

       
        

        
    }
}

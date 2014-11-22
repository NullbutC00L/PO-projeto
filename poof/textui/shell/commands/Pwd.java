package poof.textui.shell.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Directory;
import poof.core.FileSystem;
import poof.core.Shell;
import poof.textui.shell.MenuEntry;

import poof.textui.shell.ShellEdit;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para mostrar o directorio de trabalho.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Pwd extends Command<Shell> {
    
    public Pwd(Shell system) {
	super(MenuEntry.PWD, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {


    	  Display d = new Display(title());
        


        
            d.add(entity().getFileSystem().getWorkDirectory().showActualPath()
                +"/"+entity().getFileSystem().getWorkDirectory().getName());
        
        d.display();

       
     

       
        

        
    }
}

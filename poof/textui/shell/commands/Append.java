
package poof.textui.shell.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import poof.core.*;
import poof.textui.shell.MenuEntry;
import poof.textui.shell.Message;
import poof.textui.shell.ShellEdit;
import poof.textui.exception.EntryUnknownException;
import poof.textui.exception.IsNotFileException;
import poof.textui.exception.AccessDeniedException;

import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para adicionar uma linha a um ficheiro.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Append extends Command<Shell> {
    
    public Append(Shell system) {
	super(MenuEntry.APPEND, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute(){
     	 Display d = new Display(title());
     	try{
            
     		Form f=new Form(title());
	     	InputString file = new InputString(f,Message.fileRequest());
	    	f.parse();

		    	Files a= entity().getFileSystem().getWorkDirectory().getFile(file.toString());
                 
                entity().getFileSystem().checkUserFile(file.toString());
                

		    	f=new Form(title());
		    	file = new InputString(f,Message.textRequest());
		    	f.parse();
		    	a.addToFile(file.toString());
		    	
	  
        
    	}
    	catch(EntryUnknownException e){
    		d.addNewLine(e.getMessage());
    	}
    	catch(IsNotFileException e){
    		d.addNewLine(e.getMessage());
    	}
    	catch(AccessDeniedException e){
    		d.addNewLine(e.getMessage());
    	}
         finally{
        d.display();
        
        }
        
    }
}

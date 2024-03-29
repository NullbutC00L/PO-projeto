
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
import pt.utl.ist.po.ui.InvalidOperation;
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
    public final void execute() throws InvalidOperation {
     	 
     	try{
            
     		Form f=new Form(title());
	     	InputString file = new InputString(f,Message.fileRequest());
	    	f.parse();
            Form p=new Form(title());
            InputString text = new InputString(p,Message.textRequest());
            p.parse();

		    	Files a= entity().getFileSystem().getWorkDirectory().getFile(file.toString());
                 
                entity().getFileSystem().checkUserFile(file.toString());
                

		    	
		    	a.addToFile(text.toString());
		    	
	  
        
    	}
    	catch(EntryUnknownException e){
    		throw new InvalidOperation(e.getMessage());
    	}
    	catch(IsNotFileException e){
    		throw new InvalidOperation(e.getMessage());
    	}
    	catch(AccessDeniedException e){
    		throw new InvalidOperation(e.getMessage());
    	}
         
        
    }
}

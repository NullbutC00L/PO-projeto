package poof.textui.shell.commands;


import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import poof.core.*;
import poof.textui.shell.Message;
import poof.textui.shell.MenuEntry;

import poof.textui.shell.ShellEdit;
import poof.textui.exception.EntryUnknownException;
import poof.textui.exception.AccessDeniedException;
import poof.textui.exception.IllegalRemovalException;
import pt.utl.ist.po.ui.InvalidOperation;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para remover entrada.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Rm extends Command<Shell> {
    
    public Rm(Shell system) {
	super(MenuEntry.RM, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {


        
        Form f = new Form(title());
        
        
        InputString file = new InputString(f,Message.nameRequest());

        f.parse();
        try{
        	Entries entry;
        	entity().getFileSystem().getWorkDirectory().ilegal(file.toString());  // ve se e . ou ..
        	entry=entity().getFileSystem().getWorkDirectory().getEntries(file.toString()); //obtem a entry
        	entity().getFileSystem().checkUserFile(entry.getName());
            entity().getFileSystem().checkIsMyDir(entry.getName());
        	entity().getFileSystem().getWorkDirectory().remove(entry);




        }

        catch(EntryUnknownException e){
            throw new InvalidOperation(e.getMessage());
        }
        catch(AccessDeniedException e){
            throw new InvalidOperation(e.getMessage());
        }
         catch(IllegalRemovalException e){
             throw new InvalidOperation(e.getMessage());
        }
       
     

       
        

        
    }
}

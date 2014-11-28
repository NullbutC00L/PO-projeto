package poof.textui.shell.commands;

import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;
import poof.textui.shell.MenuEntry;
import poof.textui.shell.Message;
import poof.textui.shell.ShellEdit;
import pt.utl.ist.po.ui.InvalidOperation;
import poof.textui.exception.EntryUnknownException;
import poof.textui.exception.AccessDeniedException;
import poof.textui.exception.UserUnknownException;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para mudar dono de entrada.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Chown extends Command<Shell> {
    
    public Chown(Shell system) {
	super(MenuEntry.CHOWN, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        
             
    	Form f = new Form(title());
        String type;

    	InputString file_1 = new InputString(f,Message.nameRequest());
    	InputString file_2 = new InputString(f,Message.usernameRequest());


    	f.parse();
        
        try{
            entity().getFileSystem().isUser(file_2.toString());
            type=new String (entity().getFileSystem().getWorkDirectory().getEntries(file_1.toString()).getType());
            
            if (type.equals("Directory")){
                entity().getFileSystem().getCurrentUser().changeOwner
                    (entity().getFileSystem().getWorkDirectory().getListDir().get(file_1.toString()) ,file_2.toString());
            }
            else
            {
                entity().getFileSystem().getCurrentUser().changeOwner
                    (entity().getFileSystem().getWorkDirectory().getListFile().get(file_1.toString()),file_2.toString());
            }
        }
        catch(EntryUnknownException e){    ///
            throw new InvalidOperation(e.getMessage());
        }
        catch(AccessDeniedException e){ 
            throw new InvalidOperation(e.getMessage());
        }
        catch(UserUnknownException e){  ///
            throw new InvalidOperation(e.getMessage());  
        }
    }
}

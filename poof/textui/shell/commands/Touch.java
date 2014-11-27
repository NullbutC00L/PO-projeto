package poof.textui.shell.commands;


import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import poof.core.FileSystem;
import poof.core.Shell;
import poof.textui.shell.MenuEntry;
import poof.textui.shell.Message;
import poof.textui.shell.ShellEdit;
import poof.textui.exception.EntryExistsException;
import poof.textui.exception.AccessDeniedException;

import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para criar um novo ficheiro.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Touch extends Command<Shell> {
    
    public Touch(Shell system) {
	super(MenuEntry.TOUCH, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    	Display d =new Display(title());
        try{
        Form f = new Form(title());
        
    	InputString file = new InputString(f,Message.fileRequest());
    	f.parse();
       
    	entity().getFileSystem().makeFile(file.toString());
        }
        catch(AccessDeniedException e){
            d.addNewLine("Criar ficheiro: Operação inválida: "+e.getMessage());
            d.display();
        }
        catch(EntryExistsException e){
           d.addNewLine("Criar ficheiro: Operação inválida: "+e.getMessage());
            d.display();
        }

       
        

        
    }
}

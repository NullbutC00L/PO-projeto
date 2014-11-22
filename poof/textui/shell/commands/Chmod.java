package poof.textui.shell.commands;

import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;
import poof.textui.shell.MenuEntry;
import poof.textui.shell.Message;
import poof.textui.shell.ShellEdit;

import poof.textui.exception.EntryUnknownException;
import poof.textui.exception.AccessDeniedException;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para mudar permissoes de entrada.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Chmod extends Command<Shell> {
    
    public Chmod(Shell system) {
	super(MenuEntry.CHMOD, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute(){
    
    Display d = new Display(title()); 
    Form f = new Form(title());
    String type;

    InputString file = new InputString(f,Message.nameRequest());

    f.parse();

        try{
            type=new String (entity().getFileSystem().getWorkDirectory().getEntries(file.toString()).getType());


            Form g = new Form(title());

            InputString filex = new InputString(g,Message.writeMode());

            g.parse();    
    		if(filex.toString().equals("s")){
                if (type.equals("Directory")){
    			entity().getFileSystem().getCurrentUser().changePermission
                    (entity().getFileSystem().getWorkDirectory().getListDir().get(file.toString()),true);
                }
                else
                {
                    entity().getFileSystem().getCurrentUser().changePermission
                    (entity().getFileSystem().getWorkDirectory().getListFile().get(file.toString()),true);
                }


	  		}
	  		else if(filex.toString().equals("n")){
	  			  if (type.equals("Directory")){
                entity().getFileSystem().getCurrentUser().changePermission
                    (entity().getFileSystem().getWorkDirectory().getListDir().get(file.toString()),false);
                }
                else
                {
                    entity().getFileSystem().getCurrentUser().changePermission
                    (entity().getFileSystem().getWorkDirectory().getListFile().get(file.toString()),false);
                }
	  		}
        }
        catch(EntryUnknownException x){
            d.addNewLine(x.getMessage());
            d.display();
        }
        catch(AccessDeniedException e){
            d.addNewLine(e.getMessage());
            d.display();
        }
        
    }
}
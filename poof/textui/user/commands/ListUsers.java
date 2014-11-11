package poof.textui.user.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.User;
import poof.core.Shell;
import poof.textui.user.MenuEntry;

import poof.textui.user.UserEdit;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para listar todos os utilizadores.	
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class ListUsers extends Command<Shell> {
    
    public ListUsers(Shell system) {
	super(MenuEntry.LIST_USERS, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display d = new Display(title());
        d.add("-------- User --------");

        for(User u:entity().getFileSystem().getAllUsers()){
            d.addNewLine(u.toString());
        }
        d.addNewLine("-------------------------");
        d.display();

       
        

        
    }
}

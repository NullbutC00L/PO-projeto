package poof.textui.main.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;

import poof.textui.main.MenuEntry;
import poof.textui.user.UserEdit;
import pt.utl.ist.po.ui.Menu;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para ir para o menu utilizador.	
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Menu_User extends Command<Shell> {
    
    public Menu_User(Shell system) {
	super(MenuEntry.MENU_USER_MGT, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    Menu menu = new UserEdit(entity());
	menu.open();
	
		
       
        

        
    }
}

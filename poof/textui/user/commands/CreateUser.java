package poof.textui.user.commands;


import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;
import poof.textui.user.MenuEntry;
import poof.textui.user.Message;
import poof.textui.user.UserEdit;

import java.io.IOException;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.InvalidOperation;
/**
* Comando para criar um novo Utilizador.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class CreateUser extends Command<Shell> {
    
    public CreateUser(Shell system) {
	super(MenuEntry.CREATE_USER, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation{
    	
        Form f = new Form(title());

        InputString file_1 = new InputString(f,Message.nameRequest());
    	InputString file = new InputString(f,Message.usernameRequest());
    	
         
        f.parse();

        entity().getFileSystem().createUser(file_1.toString(),file.toString());

       
        
       
       
        
        
        
 
        
        

       
     

       
        

        
    

     

       
        

        
    }
}

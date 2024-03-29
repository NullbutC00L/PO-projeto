package poof.textui.main.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import poof.core.Shell;
import poof.textui.main.MenuEntry;
import poof.textui.exception.UserUnknownException;
import pt.utl.ist.po.ui.InvalidOperation;
import poof.textui.main.Message;
import poof.textui.main.MainEdit;
import java.io.IOException;


import static pt.utl.ist.po.ui.UserInteraction.IO;


/**
* Comando para fazer o login.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/




public class Login extends Command<Shell> {
    
    public Login(Shell system) {
	super(MenuEntry.LOGIN, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute()throws InvalidOperation {
    		Display d = new Display(title());
    		try{
	        Form f = new Form(title());
	    	InputString file = new InputString(f,Message.usernameRequest());
	         
	        f.parse();

	        entity().loginTry(file.toString());
	        d.display();
	     	}
	     	catch(UserUnknownException e){
                     throw new InvalidOperation(e.getMessage());
            
        }   
        

       
        

        
   		 


}
}

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
import poof.textui.exception.UserExistsException;
import poof.textui.exception.AccessDeniedException;
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
    public final void execute() {
    	
        Form f = new Form(title());
        InputString file = new InputString(f,Message.usernameRequest());
         f.parse();
        Form f1 = new Form(title());
        InputString file_1 = new InputString(f1,Message.nameRequest());
    	
    	Display d = new Display(title());
         
        f1.parse();

        try{



        entity().getFileSystem().createUser(file.toString(),file_1.toString());

        }






        catch (UserExistsException  e){
             d.addNewLine("Criar utilizador: Operação inválida: "+e.getMessage());
             d.display();

        }
        
        catch (AccessDeniedException e ){
            d.addNewLine("Criar utilizador: Operação inválida: "+e.getMessage());
            d.display();


        }

       
        
       }
       
        
       

        
    
}

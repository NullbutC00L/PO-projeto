package poof.textui.main.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import poof.core.Shell;
import poof.textui.main.MenuEntry;
import poof.textui.main.Message;

import poof.textui.main.MainEdit;
import java.io.IOException;



import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para abrir um sistema de ficheiros	.	
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Open extends Command<Shell> {
    
    public Open(Shell system) {
	super(MenuEntry.OPEN, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    	entity().create();
        try{
        Form f = new Form(title());
    	InputString file = new InputString(f,Message.openFile());
         
        f.parse();
       
        
        
        entity().copyState(Shell.open(file.toString()));
        
        

        ((MainEdit)menu()).showOptionsNonEmptyEditor();
       
        
        
        
        
    
        
        
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

       
     

       
        

        
    }
}

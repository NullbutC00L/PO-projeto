package poof.textui.main.commands;

import java.io.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;
import poof.core.Shell;
import poof.textui.main.MenuEntry;
import poof.textui.main.Message;
import pt.utl.ist.po.ui.InputString;

import poof.textui.main.MainEdit;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para guardar o actual estado do sistema de ficheiros.	
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Save extends Command<Shell> {
    
    public Save(Shell system) {
	super(MenuEntry.SAVE, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    	try{

            if (entity().getName()==null){
            Form f = new Form(title());

            InputString file = new InputString(f, Message.newSaveAs());
         
            f.parse();
  

       
            Shell.save(file.toString(), entity());
            entity().setName(file.toString());
            }
            else{
                Shell.save(entity().getName(), entity());

            }

        
        }
        catch(IOException e){
        e.printStackTrace();
        }
     

       
        

        
    }
}

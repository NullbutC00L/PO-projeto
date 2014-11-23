package poof.textui.main.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;
import poof.textui.main.MenuEntry;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InputString;
import poof.textui.main.Message;
import poof.textui.main.MainEdit;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para criar um novo sistema de ficheiros.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class New extends Command<Shell> {
    
    public New(Shell system) {
	super(MenuEntry.NEW, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display d = new Display(title());
        Form f = new Form(title());
        try{
        if(entity().getFileSystem().getState()){

            InputBoolean sav = new InputBoolean(f,Message.saveBeforeExit());
            f.parse();

            if(sav.toString().equals("sim")){            
                if(entity().getName()==null){
                    f= new Form(title());
                    InputString name = new InputString(f,Message.newSaveAs());
                    f.parse();
                    Shell.save(name.toString(),entity());
                    entity().setName(name.toString());
                }
                else{
                    Shell.save(entity().getName(),entity());
                }
            }
        }
        
        
        ((MainEdit)menu()).showOptionsNonEmptyEditor();
        entity().create();
        entity().loginTry("root");
        }

        catch(Exception e){
            System.out.println("algo correu mal");
        }
    	
    	

     

       
        

        
    }
}

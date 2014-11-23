package poof.textui.main.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
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

    	entity().create();
        
        f = new Form(title());
    	InputString file = new InputString(f,Message.openFile());
         
        f.parse();
       
        
        
        entity().copyState(Shell.open(file.toString()));
        
        

        ((MainEdit)menu()).showOptionsNonEmptyEditor();
       
        
        
        
        
    
        
        
        }
        catch(IOException e){
            d.addNewLine(Message.fileNotFound());
            d.display();
        }
        catch(ClassNotFoundException e){
            d.addNewLine(Message.fileNotFound());
            d.display();
        }

       
     

       
        

        
    }
}

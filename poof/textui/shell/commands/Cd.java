package poof.textui.shell.commands;

import java.io.*;

import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Shell;
import poof.core.FileSystem;
import poof.core.Directory;
import poof.core.Files;

import poof.textui.shell.MenuEntry;
import poof.textui.shell.Message;
import poof.textui.shell.ShellEdit;

import poof.textui.exception.EntryUnknownException;
import poof.textui.exception.IsNotDirectoryException;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para mudar o directório de trabalho.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Cd extends Command<Shell> {
    
    public Cd(Shell system) {
	super(MenuEntry.CD, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    	Display d = new Display(title());

        Form f = new Form(title());
        
        
        InputString file = new InputString(f,Message.directoryRequest());

        f.parse();
        try{
        	if (!file.toString().equals(".")){
        	if(file.toString().equals(".."))
        		{
                    if (entity().getFileSystem().getWorkDirectory().getFather()!=null){
        		        entity().getFileSystem().jump
        		 		(entity().getFileSystem().getWorkDirectory().getFather());
                    }

        		}
        	else{
        	entity().getFileSystem().getWorkDirectory().isDir(file.toString());
        	entity().getFileSystem().jump
        		 				 ( entity().getFileSystem().getWorkDirectory().nextDir
        		 					(file.toString()));
        	
        	}
            
        }
    }

        catch(EntryUnknownException e){
            d.addNewLine(e.getMessage());
        }
        catch(IsNotDirectoryException e){
            d.addNewLine(e.getMessage());
        }
        finally{
        d.display();
        
        }
       
     

       
        

        
    }
}

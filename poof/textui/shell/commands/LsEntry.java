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
import poof.core.Entries;

import poof.textui.shell.MenuEntry;
import poof.textui.shell.Message;
import poof.textui.shell.ShellEdit;
import pt.utl.ist.po.ui.InvalidOperation;
import poof.textui.exception.EntryUnknownException;
import poof.textui.exception.IsNotFileException;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para listr entradas.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class LsEntry extends Command<Shell> {
    
    public LsEntry(Shell system) {
	super(MenuEntry.LS_ENTRY, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {



        Display d = new Display(title());
        Form f = new Form(title());
        String type;
        int tamanho;
         Directory u = entity().getFileSystem().getWorkDirectory();
        
        
        InputString file = new InputString(f,Message.nameRequest());

        f.parse();
        try{
          Entries entry;
          entry=entity().getFileSystem().getWorkDirectory().getEntries(file.toString());
          if (entry.getType().equals("File"))
          {
              tamanho=entry.getSize();
              d.addNewLine(entry.choseFileDir()+entry.permissionToString()
                  +entry.getOwner()+" "+tamanho+" "+entry.getName());

          }
          else{
            entry=entity().getFileSystem().getWorkDirectory().getListDir().get(file.toString());

            d.addNewLine("d "+entry.permissionToString()+u.getName()+" "+(u.getSize())*8+" "+ entry.getName());
            
           
                
          }
        }

        catch(EntryUnknownException e){
            throw new InvalidOperation(e.getMessage());
        }
        
        finally{
        d.display();
        
        } 
        

        
    }
}

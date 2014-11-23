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
    public final void execute() {

/*

        Display d = new Display(title());
        Form f = new Form(title());
        String type;
         Directory u = entity().getFileSystem().getWorkDirectory();
        
        
        InputString file = new InputString(f,Message.fileRequest());

        f.parse();
        try{
        	 type = entity().getFileSystem().getWorkDirectory().getEntries(file.toString()).getType();


          d.addNewLine("d "+u.permissionToString(u)+u.getName()+" "+(u.getSize())*8+" .");

          d.addNewLine("d "+u.getFather().permissionToString(u.getFather())+u.getFather().getOwner()+" "+(u.getFather().getSize())*8+" ..");

          if (type.equals("Directory")){
          	 int tamanho=(u.getListDir().get(f.toString()).getSize())*8;
          	d.addNewLine("d "+u.getListDir().get(f.toString()).permissionToString(u)
          				+u.getListDir().get(f.toString()).getOwner()+" "+tamanho+" "+u.getListDir().get(f.toString()).getName());
     	 }	

     	 else{


     	 }





        }

        catch(EntryUnknownException e){
            d.addNewLine(e.getMessage());
        }
        catch(IsNotFileException e){
            d.addNewLine(e.getMessage());
        }
        finally{
        d.display();
        
        }
     

       
        
*/
        
    }
}

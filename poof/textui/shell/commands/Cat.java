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
* Comando para ver conteudo de ficheiro.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Cat extends Command<Shell> {
    
    public Cat(Shell system) {
	super(MenuEntry.CAT, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute(){

        Display d = new Display(title());
        Form f = new Form(title());
        
        
        InputString file = new InputString(f,Message.fileRequest());

        f.parse();
        try{


            d.addNewLine(entity().getFileSystem().getWorkDirectory().getFile(file.toString()).getText());
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
    }
}

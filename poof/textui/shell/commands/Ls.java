package poof.textui.shell.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import poof.core.Entries;
import poof.core.Shell;
import poof.textui.shell.MenuEntry;

import poof.textui.shell.ShellEdit;


import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
* Comando para listar.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Ls extends Command<Shell> {
    
    public Ls(Shell system) {
	super(MenuEntry.LS, system);
    }

    
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
    	Display d = new Display(title());
        d.add("-------- Entries --------");
        System.out.println(entity().getFileSystem().getCurrentUser().getDir().getEntries());
        String permission;
        for(Entries u:entity().getFileSystem().getCurrentUser().getDir().getEntries()){
            int tamanho=((2+entity().getFileSystem().getCurrentUser().getDir().getEntries().size()))*8;
            if (u.getPermission()==true){
                permission=new String("w ");
            }
            permission=new String("- ");

            d.addNewLine("d "+permission+u.getName()+" "+tamanho);
        }
        d.addNewLine("-------------------------");
        d.display();  

       
        

        
    }
}

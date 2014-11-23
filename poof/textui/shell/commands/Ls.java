package poof.textui.shell.commands;



import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

import poof.core.Entries;
import poof.core.Shell;
import poof.core.Directory;
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
        Directory u = entity().getFileSystem().getWorkDirectory();
    	Display d = new Display(title());
    int tamanho;


          d.addNewLine("d "+u.permissionToString()+u.getName()+" "+(u.getSize())*8+" .");
          if (u.getName().equals("home")){
            d.addNewLine("d "+ "- " + "/ "+ 8 +" ..");
          }
          else{
            d.addNewLine("d "+u.getFather().permissionToString()
                +u.getFather().getOwner()+" "+(u.getFather().getSize())*8+" ..");
          }

         


        
        if( entity().getFileSystem().getWorkDirectory().getOrder()!=null){
        for(Entries e: entity().getFileSystem().getWorkDirectory().getOrder()){
            if (e.getType().equals("Directory")){
             tamanho=(e.getSize())*8;
            }
            else{
              tamanho=e.getSize();
            }
            

            d.addNewLine(e.choseFileDir()+e.permissionToString()+e.getOwner()+" "+tamanho+" "+e.getName());
          
        }
        }
        d.display();  

       
        

        
    }
}

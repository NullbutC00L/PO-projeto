package poof.textui;

import poof.textui.main.MainEdit;

import poof.parser.ParseFile;



import poof.textui.main.MenuEntry;
import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;

/**
 * Forms editor application: allows the creation and manipulation of
 * graphical forms such as squares, circles, and lines.
 * Forms can be created, moved, and deleted.
 * 
 * @author Programação com Objectos
 * @version 3.0
 */
public class Shell {

    /**
     * @param args command line arguments.
     */
    public static void main(String args[]) {

        poof.core.Shell system= new poof.core.Shell();

    if (System.getProperty("import")!=null){
        ParseFile text=new ParseFile();
        try{
            system.loginTry("root");
        system.getFileSystem().changeFileSystem(text.parse(System.getProperty("import")));
        system.loginTry("root");
        
        }
        catch(Exception e){
            System.out.println("algo correu mal");
        }
        Menu menu = new MainEdit(system);
        ((MainEdit)menu).showOptionsNonEmptyEditor();
        menu.open();
        IO.close();

    }
    else{
        try{
        system.loginTry("root");
        }
        catch(Exception e){
            System.out.println("algo correu mal");
        }
	   Menu menu = new MainEdit(system);
	   menu.open();
	   IO.close();
    }
	
    }
}

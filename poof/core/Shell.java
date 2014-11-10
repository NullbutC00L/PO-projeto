package poof.core;
import java.io.Serializable;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
* Class que permite inicializar o sistema de ficheiros
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/

public class Shell implements Serializable{
    FileSystem _system=new FileSystem();

	/**
    * create cria um novo sistema de ficheiros	
    * 
    */
	public void create(){
        _system=new FileSystem();

	    
	}


	/**
    * save guarda o estado do sistema de ficheiros.
    * 
    * @param path e o nome que se quer guardar o sistema de ficheiros.
    * @param system e o sistema de ficheiros que se quer guadar.
    * 
    */

	public static void save(String path, Shell system) throws IOException{
        ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
        stream.writeObject(system);
        stream.flush();
        stream.close();
    }

    /**
    * Save guarda o estado do sistema de ficheiros.
    * 
    * @param path e o nome do sistema de ficheiros que se quer abrir.
    * @return edit que e o sistema de ficheiros aberto.
    * 
    */

    public static Shell open(String path) throws IOException , ClassNotFoundException{
        ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
        Shell edit;
        edit=(Shell)stream.readObject();
        stream.close();
        return edit;
   }


   /**
    * getFileSystem devolve o sistema de ficheiros da respectiva shell
    * 
    * @return _system e o sistema de ficheiros
    * 
    */


   public FileSystem getFileSystem(){
    return _system;
   }


   /**
    * copy actualiza o estado do actual da shell 	
    * 
    * 
    * @param shell e a shell que vai actualizar a actual.
    * 
    */
   public void copyState(Shell shell){
    if((shell.getFileSystem().getAllUsers()) instanceof List){  
    System.out.println("Aqui"+shell.getFileSystem().getAllUsers());}

      
    _system.setUser(shell.getFileSystem().getAllUsers());
        
   }
    

   /**
    * showActualPath mosta o caminho absoluto do directorio de trabalho
    * 
    * @return 
    * 
    */

   public String showActualPath(){
        String path="anibals";
        return path;

   }

	
}
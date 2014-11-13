package poof.parser;

import poof.textui.exception.*;
import poof.core.*;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * É necessário preencher os métodos createEntry e createUser de acordo com a interface
 * e funcionalidade das entidades do domínio da aplicação concretizadas por cada grupo.
 *
 * Os alunos podem ter utilizados outros nomes para representar as entidades Sistema de Ficheiros,
 * directório (Directory), ficheiro (File) e a super classe comum a directório e ficheiro (Entry).
 * Se for esse o caso, então é necessário substituir neste ficheiro estes nomes pelos nomes utilizados
 * por cada grupo.
 **/

public class ParseFile {

  private FileSystem _fileSystem;

  public FileSystem parse(String fileName) {
    try{
    BufferedReader reader = new BufferedReader(new FileReader(fileName));

    _fileSystem = new FileSystem();

    String line;

    while ((line = reader.readLine()) != null) {
      parseLine(line);
    }
    
    
     }
    catch(IOException e){
      e.printStackTrace();
    }
    return _fileSystem;
 
  }


  public void parseLine(String line) {
    String[] args = line.split("\\|");
    
    switch (args[0]) {
    case "USER":
      createUser(args[1], args[2], args[3]);
      break;
    case "DIRECTORY":
      createDirectory(args[1], args[2], args[3]);
      break;
    case "FILE":
      createFile(args[1], args[2], args[3], args[4]);
      break;
    }
  }
  
  public void createUser(String username, String name, String homeDir) {
     try{_fileSystem.createUser(username,name);
    }
    catch(AccessDeniedException e){
      e.printStackTrace();
    }
    catch(UserExistsException e){
      e.printStackTrace();
    }
  }

  private Entries createEntry(String path, String username, String permission, boolean isDir) {
 
    String[] args = path.split("/");
      
    Entries entry;
    boolean bool=false;
    if (permission.equals("public")){
      bool=true;
    }

    //if (isDir) 
      

    
      for(int i=2;i<args.length;i++){
        

       
          if (_fileSystem.getCurrentUser().getDir().searchDir(args[i]))
          {
            _fileSystem.getCurrentUser().setDir(_fileSystem.getCurrentUser().getDir().getListDir().get(args[i]));
            System.out.println("existe um igual vamos em frente-> "+_fileSystem.getCurrentUser().getDir().getListDir());
             
            
          }
          else{
            
            _fileSystem.getCurrentUser().getDir().createSubDir(args[i]);
            System.out.println("fizemos um subdir-> "+_fileSystem.getCurrentUser().getDir().getListDir());
            
            _fileSystem.getCurrentUser().setDir(_fileSystem.getCurrentUser().getDir().getListDir().get(args[i]));

            System.out.println("depois->"+_fileSystem.getCurrentUser().getDir());
           
            
            



          }
            System.out.println(_fileSystem.getCurrentUser().getDir().showActualPath());
        }
        
        
        _fileSystem.getCurrentUser().setDir(_fileSystem.getCurrentUser().getDir().getInitialPath());
        
       System.out.println("vou entrar no change");

       _fileSystem.getCurrentUser().changeOwner(_fileSystem.list().get(args[2]), args[3],bool);
          

        System.out.println("root path"+_fileSystem.getCurrentUser().getDir());
       

      

        _fileSystem.getCurrentUser().getDir().removeValue(args[2]);

        System.out.println("depois de apagado"+_fileSystem.getCurrentUser().getDir());

    return null;
  }

  public void createFile(String path, String username, String permission, String content) {
    Files file = (Files)createEntry(path, username, permission, false);
      
    file.addToFile(content);
  }

    public void createDirectory(String path, String username, String permission) {
      createEntry(path, username, permission, true);
    }    

}

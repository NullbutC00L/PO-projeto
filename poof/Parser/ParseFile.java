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
    int last = path.lastIndexOf('/');
    /*String parentPath = path.substring(0, last);
    System.out.println("pai no parse caralho    " + parentPath);
    String entryName = path.substring(last + 1);
     System.out.println("entry no parse caralho   " + entryName);
     */
    String[] args = path.split("/");
    
    Entries entry;
    boolean bool=false;
    if (permission.equals("true")){
      bool=true;
    }

    //if (isDir) 
      

    
      for(int i=3;i<args.length;i++){
        System.out.println("aqui?"+args[i]);

       
          if (_fileSystem.getCurrentUser().getDir().searchDir(args[i]))
          {
            _fileSystem.getCurrentUser().getDir().jumpDir(args[i]);
             System.out.println("oi"+_fileSystem.getCurrentUser().getDir().getListDir());
            
          }
          else{
            System.out.println("antes"+_fileSystem.getCurrentUser().getDir().getListDir());
            _fileSystem.getCurrentUser().getDir().createSubDir(args[i]);
            System.out.println("meio"+_fileSystem.getCurrentUser().getDir().getListDir());
            System.out.println("mid value->"+ _fileSystem.getCurrentUser().getDir());
            _fileSystem.getCurrentUser().getDir().jumpDir(args[i]);
            System.out.println("depois"+_fileSystem.getCurrentUser().getDir().getListDir());  
             



          }
            
        }

      
       System.out.println(_fileSystem.getCurrentUser().getDir().getListDir());

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

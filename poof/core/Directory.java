package poof.core;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

import poof.textui.exception.EntryUnknownException;
import poof.textui.exception.IsNotFileException;
import poof.textui.exception.IsNotDirectoryException;

public class Directory extends Entries implements Serializable{


	private int _size=2;


    /**
    * directorio pai
    */
    private Directory _fatherDir;
   
    

    /**
    * lista de directorios
    */
    private Map<String, Directory> _dirs = new HashMap<String, Directory>();



    /**
    * lista de ficheiros
    */
    private Map<String, Files> _files= new HashMap<String, Files>();


    /**
    * lista de entries
    */
    private Map<String, Entries> _entries= new HashMap<String, Entries>();



   

    


	/**
    * Constructor.
    * 
    * Cria um directorio dir.
    * 
    */

	public Directory (String dir,Directory father,String user, boolean permission){
		
		super(dir,user,"Directory",permission);
        
		_fatherDir=father;
		

	}


	/**
    * creatSubDir  Cria um (sub)directorio.
    * 
    * @param name do (sub)directorio.
    * 
    */

	public void createSubDir(String name){
		_dirs.put(name,new Directory(name,this,this.getOwner(),this.getPermission()));
        _entries.put(name,new Directory(name,this,this.getOwner(),this.getPermission()));
        _size+=1;


	}

	/**
    * createFile cria um ficheiro vazio no directorio de trabalho.
    * 
    * @return Ficheiro criado.
    * 
    */

	public void createFile(String name){
			_files.put( name,new Files(name,this.getOwner(),this.getPermission()));
             _entries.put( name,new Files(name,this.getOwner(),this.getPermission()));
            _size+=1;

	}

    /**
    * toString vai dar return da String no formato correto
    * 
    * @return String directorios(directorio e directrio pai)
    * 
    */

    public String toString(){
        return "/"+_fatherDir.getName()+"/"+this.getName();
    }

    /**
    * getLisDir vai dar return do Hashmap de subdirectorios
    * 
    * @return HashMap subdirectorios
    * 
    */
    public Map<String,Directory> getListDir(){
        return _dirs;
    } 


     /**
    * getListFile vai dar return do Hashmap de Files
    * 
    * @return HashMap Files
    * 
    */
    public Map<String,Files> getListFile() {
        return _files;
    }   



    public Files getFile(String name) throws EntryUnknownException,IsNotFileException{
      if( _entries.get(name)!=null){
            if (_entries.get(name).getType().equals("File"))

                return _files.get(name);
            else 
                throw new IsNotFileException(name);
      }
      else  
        throw new EntryUnknownException( name);

    }


    public boolean isDir(String name) throws EntryUnknownException,IsNotDirectoryException{
      if( _entries.get(name)!=null){
            if (_entries.get(name).getType().equals("Directory"))

                return true;
            else 
                throw new IsNotDirectoryException(name);
      }
      else  
        throw new EntryUnknownException( name);

    }



    public Entries getEntries(String name) throws EntryUnknownException{
      if( _entries.get(name)!=null){

                return _entries.get(name);
            
      }
      else  
        throw new EntryUnknownException( name);

    }









    /**
    * getOrder vai ordenar uma lista
    * 
    * @return List ordenada
    * 
    */

    public List<Directory> getOrder(){
    
        List<Directory> list = new ArrayList<Directory>(_dirs.values());
        
        Collections.sort(list);
        return list;
    }
        /**
    * getFather vai retornar o Directorio Pai de um determinado Directorio
    * 
    * @return Directory pai
    * 
    */
    
    public Directory getFather(){
        return _fatherDir;
    }
        /**
    * setFather vai modificar o directorio pai actual para um Directorio passado nos parametros
    * 
    * @return Directory pai novo
    * 
    */
     public Directory setFather(Directory father){
        return _fatherDir=father;
    }

    /**
    * getInitialPath vai retornar o path inicial
    * 
    * @return do Directory correspondente ao directorio home
    * 
    */

    public Directory getInitialPath(){
        Directory u=this;
        while(!(u.getFather()==null)){
            u=u.getFather();
            
        }
        
        return u;

    }
    /**
    * showActualPath   vai imprimir Father e com o directorio actual
    * 
    * @return String com o Father e com o directorio actual
    * 
    */
    public String showActualPath(){
        if (getFather()==null)
            return "";
        else
            return getFather().showActualPath()+"/"+getFather().getName();
        
    }

    /**
    * searchDir verifica a existencia de um Directory
    * @param String nome do directorio
    * @return boolean que confirma a existencia ou nao de um directorio
    * 
    */
    public boolean searchDir(String name){
        if(_dirs.get(name)==null)
            return false;
        else
            return true;
    }
   
    /**
    * nextDir vai para o Subdirectory com o nome name do directorio actual
    * @param String name
    * @return Directory
    * 
    */
    public Directory nextDir(String name){
        return _dirs.get(name);
    }

    /**
    * addElement adiciona um novo subdirectory a HashMap de subdirectory
    * @param String name do subdirectory
    * @param Directory dir que vai dizer em que Directorio e para adicionar o subdirectorio
    * 
    */

    public void addElement(String name,Directory dir){
            _entries.put(name,dir);
            _dirs.put(name,dir);
            _size+=1;
        }

    /**
    * removeValue remove um subdirectorio do Directorio actual
    * @param String name do subdirectorio
    * 
    */

    public void removeValue(String name){
        _entries.remove(name);
        _dirs.remove(name);
        _size-=1;
    }
        /**
    * getSize retorna o tamanho do directorio actual
    * @return int do tamanho do directorio
    * 
    */

    public int getSize(){
        return _size;

    }

    /**
    * permissionToString vai fazer a traducao das permissoes de true/false para
    * w ou - para poder imprimir
    * @param Directory 
    * @return String permissao traduzida para string 
    * 
    */

    public String permissionToString(Directory u ){
        String permission;
        if (u.getPermission()==true){
                permission=new String("w ");
                return permission;
        }
        else{
            permission=new String("- ");
            return permission;
        }

    }










	
}
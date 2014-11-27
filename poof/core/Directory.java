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
import poof.textui.exception.IllegalRemovalException;

public class Directory extends Entries implements Serializable{


	


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
    * Constructor.
    * 
    * Cria um directorio dir.
    * 
    */

	public Directory (String dir,Directory father,String user, boolean permission){
		
		super(dir,user,"Directory",2,permission);
        
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
        
        setSize(1);


	}

	/**
    * createFile cria um ficheiro vazio no directorio de trabalho.
    * 
    * @return Ficheiro criado.
    * 
    */

	public void createFile(String name){
			_files.put( name,new Files(name,this.getOwner(),this.getPermission()));
             
            setSize(1);

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

     /**
    * getListEntrie vai dar return do Hashmap de entries
    * 
    * @return HashMap entries
    * 
    */
    public Map<String,Entries> getListEntries() {

        Map<String, Entries> entries= new HashMap<String, Entries>();
         entries.putAll(_files);
         entries.putAll(_dirs);
        return entries;
    }   



    public Files getFile(String name) throws EntryUnknownException,IsNotFileException{
       
      if( getListEntries().get(name)!=null ){
        System.out.println("getFile");
            if (getListEntries().get(name).getType().equals("File"))

                return _files.get(name);
            else 
                throw new IsNotFileException(name);
      }
      
      else  {
        
        throw new EntryUnknownException( name);
    }

    }


    public boolean isDir(String name) throws EntryUnknownException,IsNotDirectoryException{
      if( getListEntries().get(name)!=null){
            if (getListEntries().get(name).getType().equals("Directory"))

                return true;
            else 
                throw new IsNotDirectoryException(name);
      }
      else  
        throw new EntryUnknownException( name);

    }



    public Entries getEntries(String name) throws EntryUnknownException{
         
      if( getListEntries().get(name)!=null){
                System.out.println("getEntries -> " + getListEntries());

                return getListEntries().get(name);
            
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

    public List<Entries> getOrder(){
    
        List<Directory> list = new ArrayList<Directory>(_dirs.values());
        List<Files> list1 = new ArrayList<Files>(_files.values());
        List<Entries> listFinal = new ArrayList<Entries>();
                
        Collections.sort(list);
        Collections.sort(list1);
        listFinal.addAll(list);
        listFinal.addAll(list1);
        return listFinal;
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
            
            _dirs.put(name,dir);
            setSize(1);
        }

   
     

 
    public void remove(Entries entry)throws IllegalRemovalException{
        if (entry.getType().equals("File")){
             
            _files.remove(entry.getName());
            setSize(-1);
        }
        else{

            
            _dirs.remove(entry.getName());
            setSize(-1);


        }

    }

    public void ilegal(String ilegal)throws IllegalRemovalException{
        if(ilegal.equals(".")||ilegal.equals("..")){
            throw new IllegalRemovalException();
        }
    }










	
}
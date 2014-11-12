package poof.core;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;



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
    private List<Files> _files= new ArrayList<Files>();

    


	/**
    * Constructor.
    * 
    * Cria um directorio dir.
    * 
    */

	public Directory (String dir,Directory father, boolean permission){
		
		super(dir,permission);
        
		_fatherDir=father;
		_dirs.put(dir,this);

	}





	/**
    * getEntries  Devolve as varias entradas do directorio em causa.
    * 
    * @return entradas do directorio.
    * 
    */

	public List<Entries> getEntries(){
        List<Entries> entries=new ArrayList<Entries>();
        List<Directory> list = new ArrayList<Directory>(_dirs.values());

		entries.addAll(list);
        entries.addAll(_files);
        Collections.sort(entries);

        return entries;


	}



	/**
    * creatSubDir  Cria um (sub)directorio.
    * 
    * @param name do (sub)directorio.
    * 
    */

	public void createSubDir(String name){
		_dirs.put(name,new Directory(name,this,this.getPermission()));


	}

	/**
    * createFile cria um ficheiro vazio no directorio de trabalho.
    * 
    * @return Ficheiro criado.
    * 
    */

	public void createFile(String name){
			_files.add( new Files(name,this.getPermission()));

	}

    public String toString(){
        return "/"+_fatherDir.getName()+"/"+this.getName();
    }

    public Map<String,Directory> getListDir(){
        return _dirs;
    }
    
    public Directory getFather(){
        return _fatherDir;
    }


    public Directory getInitialPath(){
        if(getFather().getName().equals("home")){
            return this;
        }
        else{
            return getFather();
        }
    }

    public String showActualPath(){
        if (getFather()!=null)
            return "";
        else
            return getFather().showActualPath()+"/"+getFather().getName();
        
    }

    public void jumpDir(String name){
        this.copyDir(_dirs.get(name));


    }

    public boolean searchDir(String name){
        if(_dirs.get(name)==null)
            return false;
        else
            return true;
    }
   




    public void copyDir(Directory u){

        this._dirs= u._dirs;
        this._files= u._files;
        this._fatherDir=u._fatherDir;
        this.setName(u.getName());
    }

   





	
}
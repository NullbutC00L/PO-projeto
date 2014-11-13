package poof.core;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;



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
        entries.add(this);
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

     public Directory setFather(Directory father){
        return _fatherDir=father;
    }


    public Directory getInitialPath(){
        Directory u=this;
        while(!(u.getFather().getName().equals("home"))){
            u=u.getFather();
            //System.out.println("pichota ->>>>> "+u);
        }
        return u;

    }

    public String showActualPath(){
        if (getFather()==null)
            return "";
        else
            return getFather().showActualPath()+"/"+getFather().getName();
        
    }

    public void jumpDir(String name){
        //this.copyDir(_dirs.get(name));


    }

    public boolean searchDir(String name){
        if(_dirs.get(name)==null)
            return false;
        else
            return true;
    }

    public void changeMap(String name,String newName){

        Directory dir = _dirs.remove(name);
        
    }
   

    public Directory nextDir(String name){
        return _dirs.get(name);
    }

    
    public String getKey(){
        Set setA = new HashSet();
        setA=_dirs.keySet();
        for(Object object : setA) {

            return (String)object;

        }
        return null;
    }

    public void addElement(String name,Directory dir){
            _dirs.put(name,dir);
        }
    public void removeValue(String name){
        _dirs.remove(name);
    }


   





	
}
package poof.core;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


public class Directory extends Entries implements Serializable{


	/**
    * Directorio 
    */
	private String _dir;


    /**
    * directorio pai
    */
    private String _fatherDir;
   
    

    /**
    * lista de directorios
    */
    private List<Directory> _dirs= new ArrayList<Directory>();

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

	public Directory (String dir,String father, boolean permission){
		
		super(dir,permission);
		_fatherDir=father;
		_dirs.add(this);;

	}





	/**
    * getEntries  Devolve as varias entradas do directorio em causa.
    * 
    * @return entradas do directorio.
    * 
    */

	public List getEntries(){
        List<Entries> entries=new ArrayList<Entries>();
		entries.addAll(_dirs);
        entries.addAll(_files);

        return entries;


	}



	/**
    * creatSubDir  Cria um (sub)directorio.
    * 
    * @param name do (sub)directorio.
    * 
    */

	public void createSubDir(String name){
		_dirs.add(new Directory(name,_fatherDir,this.getPermission()));


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




	
}
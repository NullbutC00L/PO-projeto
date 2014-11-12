package poof.core;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;






/**
* Class que permite gerir o sistema de ficheiros.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/




public class FileSystem implements Serializable{


    private Directory _dir=new Directory("home",null,false);
    
    /**
    * lista de utilizadores
    */
    private Map<String, User> _user = new HashMap<String, User>();
    
    private User _currentUser= new SuperUser(_dir);
  

    /**
    * lista de Path
    */
    private List<Directory> _path= new ArrayList<Directory>();

    public FileSystem(){
        _user.put(_currentUser.getUserName(),_currentUser);
        _path.add(_dir); //tou a criar o directorio principal
        _path.add(_currentUser.getDir());  //acho que no super user se deve usar o comando subdir e nao o construtor.

    }


    public List<Directory> getWorkDirectory(){
        return _path;
    }




	/**
    * list lista todos os utilizadores.
    * 
    * @return uma lista.
    * 
    */

	public Map<String,User> list(){
        return _user;
       

	}

	/*
    * list lista todas as entradas.
    * 
    * @return uma lista.
    * 
    */


	public List listElement(){//////////////////////////////////////////////////////////////////////////
        return _path;

	}

	
    public void makeDir(String name){

        
                _currentUser.getDir().createSubDir(name);
                System.out.println(_currentUser.getDir().getEntries());
            


        

    }

	/**
    * changeWorkDirectory remove a entrada do directorio de trabalho.
    * 
    * @return e o novo directorio de trabalho.
    * 
    */

	public void addDirectory(Directory dir){
        _path.add(dir);
	}



    public void removeDirectory(){
        _path.remove(_path.size()-1);
    }




	/**
    * getAllUsers  obetem-se todos os utilizadores do sistema de ficheiros.
    * 
    * @return lista de todos os utilizadores.
    * 
    */

	public List<User> getAllUsers (){
        List<User> list = new ArrayList<User>(_user.values());
        Collections.sort(list);
        return list;

        


	}


	/**
    * getAllEntries  obetem-se todos os ficheiros/directorios do sistema de ficheiros.
    * 
    * @return lista de todos os ficheiros/directorios.
    * 
    */

	public List getAllEntries (){
        
        return  _path;



	}


    /**
    * creatUser cria um user ;
    * 
    * @param user e o username do utilizador.
    * @param name e o nome do utilizador.
    * 
    */


    public void createUser(String user,String name){ ////////////////////////falta o trow

        _user.put(user,new User(user,name,_dir));
        System.out.println(_user.size());

    }


    public void setUser(Map<String,User> users){
       System.out.println(users);
       _user=new HashMap<String,User>(users);



        
    }

    public void setWorkDirectory(User user){
        _path.clear();
        _path.add(_dir);
        _path.add(user.getDir());
    }

    public void changeFileSystem(FileSystem system){
        this._dir=system._dir;
        this._path=system._path;
        this._user=system._user;

    }
    public void setCurrentUser(User user){
        _currentUser=user;
    }
    public User getCurrentUser(){
        return _currentUser;
    }


    public Map<String,User> getUsers(){
        return _user;
    }








}
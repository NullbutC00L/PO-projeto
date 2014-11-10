package poof.core;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;






/**
* Class que permite gerir o sistema de ficheiros.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/




public class FileSystem implements Serializable{


    private Directory _dir;
    
    /**
    * lista de utilizadores
    */
    private List<User> _user= new ArrayList<User>();


    /**
    * lista de Path
    */
    private List<Entries> _path= new ArrayList<Entries>();

    public FileSystem(){
        _user.add(new SuperUser());
        _path.add((new SuperUser()).getDir());
    }




	/**
    * list lista todos os utilizadores.
    * 
    * @return uma lista.
    * 
    */

	public List list(){
        return _user;
       

	}

	/**
    * list lista todas as entradas.
    * 
    * @return uma lista.
    * 
    */


	public List listElement(){
        return _path;

	}

	

	/**
    * changeWorkDirectory remove a entrada do directorio de trabalho.
    * 
    * @return e o novo directorio de trabalho.
    * 
    */

	public Directory changeWorkDirectory(Directory dir){
        _dir=dir;	
        return _dir;
	}




	/**
    * getAllUsers  obetem-se todos os utilizadores do sistema de ficheiros.
    * 
    * @return lista de todos os utilizadores.
    * 
    */

	public List<User> getAllUsers (){
        Collections.sort(_user);
        return _user;

        


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


    public void createUser(String user,String name){

        _user.add(new User(user,name));
        System.out.println(_user.size());

    }


    public void setUser(List<User> users){
       System.out.println(users);
       for(User obj:users){
        _user.add(obj);
        }
        
    }










}
package poof.core;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poof.textui.exception.*;




/**
* Class que permite gerir o sistema de ficheiros.
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/




public class FileSystem implements Serializable{

     /**
    * Objecto Directorio inicial Existente
    */
    private Directory _dir=new Directory("home",null,"root",false);
    
    /**
    * HashMap de utilizadores
    */
    private Map<String, User> _user = new HashMap<String, User>();
    
     /**
    * Objecto User actual
    */
    private User _currentUser= new SuperUser(_dir);
  

    /**
    * lista de Path
    */
    private List<Directory> _path= new ArrayList<Directory>();

    /**
    *Construtor do FileSystem que vai inicializar os atributos iniciais do Filesystem
    *
    */
    public FileSystem(){
       
         _currentUser.getDir().setFather(_dir);
         

        
       
        _user.put(_currentUser.getUserName(),_currentUser);
        _path.add(_dir); //tou a criar o directorio principal
        _path.add(_currentUser.getDir());  //acho que no super user se deve usar o comando subdir e nao o construtor.
        _dir.addElement(_currentUser.getName(),_user.get(_currentUser.getUserName()).getDir());
    }

    /**
    *  getWorkDirectory vai enviar a lista de directorios
    *   @return da lista de directorios actuais do Filesystem 
    */
    public Directory getWorkDirectory(){
        return _dir;
    }




	/**
    * list lista todos os utilizadores.
    * 
    * @return um Map de Users.
    * 
    */

	public Map<String,User> list(){
        return _user;
       

	}

	/**
    * listElement lista todas as entradas por ordem.
    * 
    * @return uma lista ordenada.
    * 
    */


	public List listElement(){
        return _path;

	}

	
    /**
    *   makeDir cria um subdirectorio do directorio actual
    *   @param recebe uma string que sera o nome do novo directorio
    *
    */
    public void makeDir(String name){

        
                _dir.createSubDir(name);
                System.out.println(_dir);
            
    }





    /**
    *removeDirectory remove o ultimo directorio da lista de directorios
    *
    */
    public void removeDirectory(){
        _dir=_dir.getFather();
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


    public void createUser(String user,String name) throws AccessDeniedException,UserExistsException {
        if (_currentUser.getUserName().equals("Super User") ){
                if(_user.get(user)==null){ 
            
            
            _user.put(user,new User(user,name,_dir));
            _user.get(user).getDir().setFather(_dir);
            _dir.addElement(user,_user.get(user).getDir());
            
            //_dir.getListDir().put()
           



            }
            else
                throw new UserExistsException(user);
        }
        else
            throw new AccessDeniedException(_currentUser.getUserName());


    }

    /**
    *   setUser vai adicionar um novo user a lista de users
    *@param Map de users
    */
    public void setUser(Map<String,User> users){
       System.out.println(users);
       _user=new HashMap<String,User>(users);



        
    }
    /**
    *   setWorkDirectory apaga o directorio actual do fileSystem e vai abrir o 
    *   o directorio de trabalho do User passado
    *   @param  User 
    */

    public void setWorkDirectory(User user){
        _path.clear();
        _path.add(_dir);
        _path.add(user.getDir());
    }
    /**
    *   changeFileSystem vai mudar todos os atributos do Filesystem actual pelos
    *   atributos do novo Filesystem, passando assim o Filesystem actual a ser
    *   o Filesystem passado como parametro
    *   @param Filesystem
    */
    public void changeFileSystem(FileSystem system){
        this._dir=system._dir;
        this._path=system._path;
        this._user=system._user;

    }
    /**
    *   setCurrentUser associa um Novo objecto User ao user Actual 
    *@param  User
    *
    */
    public void setCurrentUser(User user){
        _dir=_dir.getListDir().get(user.getName());
        _currentUser=user;
    }
    /**
    *   getCurrentUser vai retornar qual e o user actualmente logado
    *   @rateurn retorna o objecto User logado actualmente no systemFile
    */
    public User getCurrentUser(){
        return _currentUser;
    }

    /**
    *   getUsers vai retornar qual e o Map actual com os utiizadores existentes
    *   @return retorna o Map de todos os utilizadosres existentes no FileSystem actual
    *
    */
    public Map<String,User> getUsers(){
        return _user;
    }

    public Directory actualDir()
    {
        return _dir;
    }

    public void jump(Directory dir){
        _dir=dir;
    }


   







}
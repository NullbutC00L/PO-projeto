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
    private boolean state=false;
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
    *Construtor do FileSystem que vai inicializar os atributos iniciais do Filesystem
    *
    */
    public FileSystem(){
        
         _currentUser.getDir().setFather(_dir);
         
         _currentUser.getDir().setOwner("root");
        _user.put(_currentUser.getUserName(),_currentUser);
        _dir.addElement(_currentUser.getUserName(),_user.get(_currentUser.getUserName()).getDir());

    }

    /**
    *  getWorkDirectory vai enviar a lista de directorios
    *   @return da lista de directorios actuais do Filesystem 
    */
    public Directory getWorkDirectory(){
        return _dir;
    }


     /**
    *   makeDir cria um subdirectorio do directorio actual
    *   @param recebe uma string que sera o nome do novo directorio
    *
    */
    public void makeDir(String name)throws EntryExistsException,AccessDeniedException{

                if(_dir.getListDir().get(name)!=null|| name.equals(".")||name.equals("..")){
                    throw new EntryExistsException(name);
                }

                else if (! (_currentUser.getUserName().equals("root")) ){
                    if(!(_dir.getOwner().equals(_currentUser.getUserName()))){
                        if(_dir.getPermission()==false){
                            throw new AccessDeniedException(_currentUser.getUserName());
                        }
                         else{
                            state=true;
                            _dir.createSubDir(name);
                         }


                    }
                    else{
                        state=true;
                        _dir.createSubDir(name);
                    }


                }

                 
                else{
                    state=true;
                    _dir.createSubDir(name);
                }
    }

    public void makeFile(String name)throws EntryExistsException,AccessDeniedException{
        if(_dir.getListFile().get(name)!=null){
            throw new EntryExistsException(name);
        }   
                    
        else if( ! (_currentUser.getUserName().equals("root"))){
                    if(!(_dir.getOwner().equals(_currentUser.getUserName()))){
                        if(_dir.getPermission()==false){
                            throw new AccessDeniedException(_currentUser.getUserName());
                        }
                    

                        else{
                            state=true;
                            _dir.createFile(name);
                        }
                    }
                    else{
                        state=true;
                        _dir.createFile(name);
                    }
        }
            
        else{
            state=true;
            _dir.createFile(name);
        }
    }





    /**
    *removeDirectory remove o ultimo directorio da lista de directorios
    *
    */
    public void removeDirectory(){
        state=true;
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
    * creatUser cria um user ;
    * 
    * @param user e o username do utilizador.
    * @param name e o nome do utilizador.
    * 
    */


    public void createUser(String user,String name) throws AccessDeniedException,UserExistsException {
        if (_currentUser.getUserName().equals("root") ){
                if(_user.get(user)==null){ 
                    state=true;
                    
                    Directory lastDir;
                    lastDir=_dir;
            
                    _dir=_dir.getInitialPath();



                    _user.put(user,new User(name,user,_dir));
                    _user.get(user).getDir().setFather(_dir);
                    _dir.addElement(user,_user.get(user).getDir());
                    _dir=lastDir;
                   
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
       _user=new HashMap<String,User>(users);



        
    }
 
    /**
    *   changeFileSystem vai mudar todos os atributos do Filesystem actual pelos
    *   atributos do novo Filesystem, passando assim o Filesystem actual a ser
    *   o Filesystem passado como parametro
    *   @param Filesystem
    */
    public void changeFileSystem(FileSystem system){
        this._dir=system._dir;
        this._user=system._user;

    }
    /**
    *   setCurrentUser associa um Novo objecto User ao user Actual 
    *@param  User
    *
    */
    public void setCurrentUser(User user){
        
        state=true;
        _dir=_dir.getInitialPath();
        _dir=_dir.getListDir().get(user.getUserName());
        
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
    
    /**
    *   vai saltar para um Directory que foi passado  no parametro
    *   o directorio vai passar a ser o directorio passado
    * @param Directory
    * 
    */
    public void jump(Directory dir){
        state=true;
        _dir=dir;
    }



        public boolean isUser(String name) throws UserUnknownException{
      if( _user.get(name)!=null){

                return true;
            
      }
      else  
        throw new UserUnknownException( name);

    }

   

    public void checkUserFile(String file)throws AccessDeniedException{

         
        if(_dir.getListEntries().get(file).getOwner().equals(_currentUser.getUserName())
            ||getCurrentUser().getUserName().equals("root") 
                ||_dir.getListEntries().get(file).getPermission()==true){

        }
        else{
            throw new AccessDeniedException(_currentUser.getUserName());
        }


    }







    public void setState(){
        state=false;
    }


    public boolean getState(){
        return state;
    }

    public void setDir(Directory dir){
        _dir=dir;

    }

    public void setCurrentUserOpen(User user){
        _currentUser=user;
    }





}
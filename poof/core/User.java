package poof.core;
import java.io.Serializable;
import poof.textui.exception.AccessDeniedException;

/**
* Class User permite criar um User
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/

public class User implements Serializable , Comparable< User>{

	/**
    * Username escolhido
    */
	private String _userName;

	/**
    * Nome do utilizador
    */
	private String _name;

	/**
    * Directorio do utilizador
    */
	private Directory _directory;
	
	/**
    * Constructor. _directory;
    * 
    * @param user e o username do utilizador.
    * @param name e o nome do utilizador.
    * 
    */

	public User (String name,String user,Directory dir ){
		_userName=user;
		_name=name;

        _directory= new Directory(user,dir,user,false); 
        

	}
    /**
    * Troca o directorio actual por um directorio passado nos parametros
    * 
    * @param directorio que vamos atribuir o novo directorio
    * 
    */

    public void setDir(Directory dir )
    {
        _directory=dir;
    }


	/**
    * Troca a permissao de um directorio/ficheiro
    * 
    * @param entry e directorio/ficheiro no qual queremos trocar as permissoes
    * @param permission e a permissao que queremos dar a um directorio/ficheiro
    * 
    */

	public void changePermission(Entries entry, boolean permission)throws AccessDeniedException{

        if (entry.getOwner().equals(_userName) ||_userName.equals("root")){
            entry.setPermission(permission);
           
        }
        else{
            throw new AccessDeniedException(_userName);
        }
	}

	/**
    * Troca o dono de um directorio/ficheiro
    * 
    * @param entry e directorio/ficheiro no qual queremos trocar o dono
    * @param owner e o novo dono de um directorio/ficheiro
    * 
    */

	public void changeOwner(Entries entry,String name)throws AccessDeniedException{
    if (entry.getOwner().equals(_userName) ||_userName.equals("root")){
            entry.setOwner(name);
           
        }
        else{
            throw new AccessDeniedException(_userName);
        }
        

	} 
    /**
    * da-nos return do nome do User
    * 
    * @return da return do nome do User
    * 
    */

     public String getName(){
        return _name;
    }
    /**
    * da-nos return do nome do UserName
    * 
    * @return da return do nome do userName
    * 
    */
    public String getUserName(){
        return _userName;
    }
   /**
    * da-nos o Directorio do objecto User
    * 
    * @return da return do Directorio
    * 
    */
    public Directory getDir(){
        return _directory; 
    }
   /**
    * passa os parametros do User para o Formato de String que queremos
    * 
    * @return parametros do User em String
    * 
    */
    public String toString()
    {
        return  (_userName + ":" +_name + ":"+_directory.toString());
    }
   /**
    * Compara dois Users e e utilizado para o sort
    * @param Recebe o Objecto User 
    * @return o inteiro que vai tratar da organizacao da Lista de Users
    * 
    */
    public int compareTo(User other)
    {
        return _userName.compareTo(other._userName);
    }






	
}

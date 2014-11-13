package poof.core;
import java.io.Serializable;

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

        _directory= new Directory(name,dir,false); 
        

	}

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

	public void changePermission(Entries entry, boolean permission){
        if (entry.getName()==_userName){
        entry.setPermission(permission);
            }

	}

	/**
    * Troca o dono de um directorio/ficheiro
    * 
    * @param entry e directorio/ficheiro no qual queremos trocar o dono
    * @param owner e o novo dono de um directorio/ficheiro
    * 
    */

	public void changeOwner(User user,String name,boolean bool){
        /*
            if( user.getName()==_userName){
            entry.setName(owner);
        }
        */

	}

     public String getName(){
        return _name;
    }

    public String getUserName(){
        return _userName;
    }

    public Directory getDir(){
        return _directory; 
    }

    public String toString()
    {
        return  (_userName + ":" +_name + ":"+_directory.toString());
    }

    public int compareTo(User other)
    {
        return _userName.compareTo(other._userName);
    }






	
}

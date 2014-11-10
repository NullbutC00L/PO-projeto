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

	public User (String user,String name ){
		_userName=user;
		_name=name;
        _directory= new Directory("home",name,false);
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

	public void changeOwner(Entries entry, String owner){
        
            if( entry.getName()==_userName){
            entry.setName(owner);
        }

	}



    public Directory getDir(){
        return _directory; 
    }


    public int compareTo(User other)
    {
        return _userName.compareTo(other._userName);
    }




	
}

package poof.core;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

/**
* Class SuperUser permite criar um Super User
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/

public class SuperUser extends User implements Serializable{
		
	/**
    * Directorio atribuido ao super user
    */
	


	/**
    * Constructor.
    * 
    * Cria um user chamado root.
    * 
    * 
    */


	public SuperUser(Directory father){
		
		super("Super User","root",father);
        
		//_dir=new Directory("root",father,false);// aqui deve ser  subdirectory shit
    }
	/**
    * Troca a permissao de um directorio/ficheiro.
    * 
    * @param entry e directorio/ficheiro no qual queremos trocar as permissoes
    * @param permission e a permissao que queremos dar a um directorio/ficheiro
    * 
    */
    @Override
	public void changePermission(Entries entry, boolean permission){
          entry.setPermission(permission);
          
          


	}

	/**
    * Troca o dono de um directorio/ficheiro.
    * 
    * @param entry e directorio/ficheiro no qual queremos trocar o dono
    * @param owner e o novo dono de um directorio/ficheiro
    * 
    */
     @Override
	public void changeOwner(Entries entry,String name){
        entry.setOwner(name);
       

        
    }

    


}
   


	

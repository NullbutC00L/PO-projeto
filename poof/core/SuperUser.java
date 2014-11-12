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
	Directory _dir;


	/**
    * Constructor.
    * 
    * Cria um user chamado root.
    * 
    * 
    */


	public SuperUser(Directory father){
		
		super("root","Super User",father);
        _dir=this.getDir();
		//_dir=new Directory("root",father,false);// aqui deve ser  subdirectory shit
    }
	/**
    * Troca a permissao de um directorio/ficheiro.
    * 
    * @param entry e directorio/ficheiro no qual queremos trocar as permissoes
    * @param permission e a permissao que queremos dar a um directorio/ficheiro
    * 
    */

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
	public void changeOwner(User user,String name){
        boolean x=false;
        System.out.println("changeOwner"+user);
        _dir.setName(user.getName());
        _dir.changeMap(this.getName(),user.getName());
        
        if(user.getDir().getListDir().size()==0){
            System.out.println("entrei");
            user.setDir(_dir);
        }
        else{
            Directory next=user.getDir();
            while(x==true){
                 if (next.getListDir().get(name)!=null)
                {
                user.getDir().addElement(name,_dir.getListDir().get(name));
                   x=false; 
            
                }
                else{
                    
                    name=( String)_dir.getKey();
                    _dir=_dir.nextDir(name);
                    next=next.nextDir(name);


                    
                    
                    
                    
                    
                    



                    }
            }

            _dir=_dir.getInitialPath();
            user.setDir(next.getInitialPath());
        }


        


    }


    


}
   


	

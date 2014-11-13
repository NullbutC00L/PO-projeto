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
	public void changeOwner(User user,String name, boolean bool){
        
        boolean x=true;
        Directory next=user.getDir();
        System.out.println("username->"+user.getName());
        Directory dir=_dir.getListDir().get(user.getName());
        dir=dir.getListDir().get(name);
      

        System.out.println("changeOwner"+user);

        System.out.println("dir"+dir);
       
        if(user.getDir().getListDir().size()==0){
            System.out.println("entrei_1");

            dir.setFather(next);
            System.out.println("next->"+ next+ "father do dir"+dir.getFather());
            user.getDir().addElement(name,dir);

            user.getDir().getListDir().get(name).setPermission(bool);
        }
        
        else{
            
            while(x==true){
                 if (next.getListDir().get(name)==null)
                {
                    System.out.println("entrei_2 de nome"+name);
                
                dir.setFather(next);
                
                user.getDir().addElement(name,dir);
                 user.getDir().getListDir().get(name).setPermission(bool);
                System.out.println("show->"+dir.showActualPath()+"/"+dir.getName());
                   x=false; 
            
                }
                else{
                    System.out.println("entrei_3 nome"+name);
                    name=( String)dir.getKey();
                    System.out.println("name ->"+name);
                     System.out.println("amntes next ->"+next);
                    System.out.println("antes dir ->"+dir);
                    dir=dir.nextDir(name);
                    System.out.println("dir ->"+dir);
                    if(next.nextDir(name)!=null){
                        next=next.nextDir(name);
                    }
                    System.out.println("next ->"+next);





                    }
            }

            dir=dir.getInitialPath();
            
            
            user.setDir(next.getInitialPath());

        }
            
            
        //System.out.println("boooooooooleannnn passado na func-> "+bool+"");
          //0
          
            System.out.println("booollll no dir caralhooooo -> "+user.getDir().getPermission()+"");

        
        System.out.println("sai"+user.getDir().showActualPath());

    }


    


}
   


	

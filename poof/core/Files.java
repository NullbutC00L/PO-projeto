package poof.core;
import java.io.Serializable;

/**
* Class que permite inicializar o sistema de ficheiros
* 
* 
* @author Fabio Gomes- 177924 ,Antonio Freire- 177969 ,Joao Rodrigues- 177992
* @version 0.1
*/


public class Files extends Entries implements Serializable{


	
	/**
    * texto do ficheiro
    */

	private String _text =new String ("");

	


	/**
    * Constructor.
    * 
    * @param username e o username do dono do ficheiro.
    * @param permission e a permissao do ficheiro.
    * 
    */

	public Files(String name,String owner ,boolean permission){
		super(name,owner,"File",0,permission);

	}


	

	/**
    * getText obtem-se o conteudo do ficheiro
    * 
    * @return _text e o conteudo do ficheiro.
    * 
    */
		
	public String getText(){
	
	return _text;
	}


	/**
    * addToFile adiciona conteudo ao ficheiro
    * 
    * @param text e o conteudo que queremos adicionar ao ficheiro.
    * 
    */
	public void addToFile (String text) {
		setSize(text.length()+1);
		_text+=(text+"\n");
		
	}

	




	

	
}
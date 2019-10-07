import java.util.ArrayList;


/**
 * This class used to save/get state of inventory
 */
 
@SuppressWarnings("serial")
public class Memento implements java.io.Serializable{

	private ArrayList<Book> bookCollection;
	private String state;
	
	public Memento(String state){
		this.state = state;
	}
//	 public String getState() {
//		 return state;
//	 }
//	
	public void saveState(ArrayList<Book> newBookCollection){
		
		this.bookCollection = new ArrayList<Book>(newBookCollection);
		
	}	
	public ArrayList<Book> getState(){
		
		return this.bookCollection;
		
	}
}

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This class used to execute addMovie method on inventory and serialize it to file.
 */

@SuppressWarnings("serial")
public class AddBookCommand extends Command implements java.io.Serializable {

	private Book book;
	private String fileName = "Command.ser";
	
	AddBookCommand(Book newBook){
	this.book = newBook; 
	}
	
	@Override
	public void execute(Inventory newInvent) {
		
		newInvent.addBook(book);
		
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream(fileName,true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
	        
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	        
	      }
	}

}

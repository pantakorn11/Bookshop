import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This class used to execute sellMovie method on inventory and serialize it to file.
 */

@SuppressWarnings("serial")
public class SellBookCommand extends Command implements java.io.Serializable {

	private String bookName;
	private String fileName = "Command.ser";
	
	SellBookCommand(String newBookName){
	this.bookName = newBookName; 
	}
	
	@Override
	public void execute(Inventory newInvent) {
		
		try {
			  newInvent.sellBook(bookName);
		} catch (MatchNotFoundException e) {
			System.out.println(e);
		}

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

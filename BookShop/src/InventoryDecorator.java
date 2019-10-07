import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class InventoryDecorator implements InventoryInterface{
	
	private Inventory invent = new Inventory();
	private FileInputStream fileIn ;
	private ArrayList<Command> commandCollection = new ArrayList<Command>();
	private CareTaker careTaker = new CareTaker();
	private Memento memento = new Memento("");
	private String CommandFileName = "Command.ser";
	
	
	public Inventory getInvent() {
		
		return invent;
	}

	public void setInvent(Inventory invent) {
		
		this.invent = invent;
	}
	
	public void addBook(Book book){
		
		AddBookCommand addBook = new AddBookCommand(book);
	    addBook.execute(invent);
	}
	
	public void addCopy(String bookName, Integer numberOfCopy){
		
		AddCopyCommand addCopy = new AddCopyCommand(bookName, numberOfCopy);
		addCopy.execute(invent);
		
	}
	
	public void changePrice(String bookName, Integer newPrice){
		
		ChangePriceCommand changePrice = new ChangePriceCommand(bookName, newPrice);
		changePrice.execute(invent);
	
	}
	
	public void sellBook(String bookName){
		
		SellBookCommand sellBook = new SellBookCommand(bookName);
		sellBook.execute(invent);
	}
	
	public Integer findPriceByName(String bookName) throws MatchNotFoundException{
		
		try {
			
			return invent.findPriceByName(bookName);
			
		} catch (MatchNotFoundException e) {
			
			throw new MatchNotFoundException("No Match Found");
		}
	}
	
	public Integer findPriceByID(Integer bookID) throws MatchNotFoundException{
		
		try {
			
			return invent.findPriceByID(bookID);
			
		} catch (MatchNotFoundException e) {
			
			throw new MatchNotFoundException("No Match Found");
		}
	}
	
	public Integer findQuantityByName(String bookName) throws MatchNotFoundException{
		
		try {
			
			return invent.findQuantityByName(bookName);
			
		} catch (MatchNotFoundException e) {
			
			throw new MatchNotFoundException("No Match Found");
		}
	}
	
	public Integer findQuantityByID(Integer bookID) throws MatchNotFoundException{
		
		try {
			 
			return invent.findQuantityByID(bookID);
			
		} catch (MatchNotFoundException e) {
			
			throw new MatchNotFoundException("No Match Found");
		}
	}
		
	/**
	   * This method get the commands from file  
	   * and also runs them to inventory object       
	   */
	
	private void replyCommands(Inventory invent){
			
		try {
				  fileIn = new FileInputStream(CommandFileName);
				  while (true) {
					ObjectInputStream input = new ObjectInputStream(fileIn);
				    commandCollection.add((Command) input.readObject());
				  }  
				}catch (EOFException e) {
					
					try{	
						fileIn.close();
					}catch(IOException i)
					{
						i.printStackTrace();
					}
					
				}catch(IOException i)
				{
					i.printStackTrace();
				}catch(ClassNotFoundException c)
				{
					System.out.println("class not found");
					c.printStackTrace();
				}
			
			for(Command command : commandCollection){
		         command.execute(invent);
			}
		}

	@Override
	public void saveState() {
		
		memento.saveState(invent.getMovieCollection());
		careTaker.serialzeMemento(memento);
		
		File file = new File(CommandFileName);
		file.delete();
		
		try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void getState() {
		
	memento = careTaker.deserialseMemento();
	invent.setMovieCollection(memento.getState());
	this.replyCommands(invent);
	
	}

}
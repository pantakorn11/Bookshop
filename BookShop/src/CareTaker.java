import java.io.*;
import java.util.ArrayList;


/**
 * This class to serialize and deserialize Memento to/from file.       
 */

public class CareTaker {
  
 private Object object;
 private String temporaryFileName = "temporaryInventory.ser";
 private String fileName = "Inventory.ser";
 private File tempFile = new File(temporaryFileName);
 private File file = new File(fileName);
 byte[] buf = new byte[1024];
 int bytesRead;
 
 private ArrayList<Memento> mementoList = new ArrayList<Memento>();
 	public void add(Memento state){
 		mementoList.add(state);
 	}
 	public Memento get(int index){
 		return mementoList.get(index);
 	}
 
   public void serialzeMemento(Memento state){
	   
	   try
	      {
	         FileOutputStream temporaryFileOut = new FileOutputStream(temporaryFileName);
	         ObjectOutputStream out = new ObjectOutputStream(temporaryFileOut);
	         out.writeObject(state);         
	         out.close();
	         temporaryFileOut.close();
	         tempFile.renameTo(file);
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	   
   }

   public Memento deserialseMemento(){	 
	   
	   try
	      {
	         FileInputStream fileIn = new FileInputStream(fileName);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         object = in.readObject();
	         in.close();
	         fileIn.close();
	         return (Memento)object;
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	         
	      }catch(ClassNotFoundException c)
	      {
	          System.out.println("class not found");
	          c.printStackTrace();
	          return null;
	          
	       }
	   
   }
   
}
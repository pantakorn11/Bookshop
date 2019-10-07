import static org.junit.Assert.*;

import org.junit.Test;


public class InventoryTest {
	
	@Test
	public void testAddMovie() {
		
		InventoryDecorator invent = new InventoryDecorator();
	    Integer price, testPrice=500;
	       
	    invent.addBook(new Book("MIB-1", 500, 5));
	       
	    try{	
				price = invent.findPriceByName("MIB-1");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				price =0;
			}
	    assertEquals("Check movie MIB-1", testPrice, price);
	}

	@Test
	public void testAddCopy() {
		
		InventoryDecorator invent = new InventoryDecorator();
	    Integer copy, testCopy=10;
	       
	    invent.addBook(new Book("MIB-1", 500, 5));
	    invent.addCopy("MIB-1", 5);   
	    try{	
				copy = invent.findQuantityByName("MIB-1");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				copy =0;
			}
	    assertEquals("Check movie MIB-1", testCopy, copy);
		
	}

	@Test
	public void testChangePrice() {
		
		InventoryDecorator invent = new InventoryDecorator();
	    Integer price, testPrice=1000;
	       
	    invent.addBook(new Book("MIB-1", 500, 5));
	    invent.changePrice("MIB-1", 1000);   
	    try{	
				price = invent.findPriceByName("MIB-1");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				price =0;
			}
	    assertEquals("Check movie MIB-1", testPrice, price);
	}

	@Test
	public void testSellMovie() {
		
		InventoryDecorator invent = new InventoryDecorator();
	    Integer copy, testCopy=4;
	       
	    invent.addBook(new Book("MIB-1", 500, 5));
	    invent.sellBook("MIB-1");   
	    try{	
				copy = invent.findQuantityByName("MIB-1");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				copy =0;
			}
	    assertEquals("Check movie MIB-1", testCopy, copy);
	}

	@Test
	public void testFindPriceByName() {
		
		InventoryDecorator invent = new InventoryDecorator();
	    Integer price, testPrice=500;
	       
	    invent.addBook(new Book("MIB-1", 500, 5));   
	    try{	
				price = invent.findPriceByName("MIB-1");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				price =0;
			}
	    assertEquals("Check movie MIB-1", testPrice, price);
	}
	
	@Test
	public void testGetState() {
		
		InventoryDecorator invent = new InventoryDecorator();
		Integer price, testPrice=500;
	       
	    invent.addBook(new Book("MIB-1", 500, 5));
	    invent.addBook(new Book("MIB-2", 600, 5));
	    invent.saveState();  
	    InventoryDecorator invent2 = new InventoryDecorator();
	    invent2.getState();
	    
	    try{	
			price = invent2.findPriceByName("MIB-1");
		}catch(MatchNotFoundException e)
		{
			System.out.println(e);
			price=0;
		}
	    
	    assertEquals("Check movie MIB-1", testPrice, price);
	    
	}

}
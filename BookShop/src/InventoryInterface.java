public interface InventoryInterface {
	
	public void addBook(Book book);
	public void sellBook(String bookName)throws MatchNotFoundException;
	public void addCopy(String bookName, Integer NumberOfCopy ) throws MatchNotFoundException;
	public void changePrice(String bookName,Integer newPrice) throws MatchNotFoundException;
	public Integer findPriceByName(String bookName) throws MatchNotFoundException;
	public Integer findQuantityByName(String bookName) throws MatchNotFoundException;
	public Integer findQuantityByID(Integer bookID) throws MatchNotFoundException;
	public Integer findPriceByID(Integer bookID) throws MatchNotFoundException;
	public void saveState();
	public void getState();
}

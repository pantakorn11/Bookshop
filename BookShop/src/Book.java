@SuppressWarnings("serial")
public class Book implements java.io.Serializable{

	private Integer  price, uniqueID, quantity;
	private String name;
	private static int count =0;
	
	Book(String newName, Integer newPrice, Integer newQuantity ){
	this.name = newName;
	this.price = newPrice;
	this.uniqueID = ++count;
	this.quantity = newQuantity;
	}
	
	public void changeQuantity(int change){
		
		this.quantity += change;

	}

	public Integer getPrice() {
		
		return price;
	}

	public void setPrice(Integer price) {
		
		this.price = price;
	}

	public Integer getUniqueID() {
		
		return uniqueID;
	}

	public void setUniqueID(Integer uniqueID) {
		
		this.uniqueID = uniqueID;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public Integer getQuantity() {
		
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		
		this.quantity = quantity;
	}
	
}

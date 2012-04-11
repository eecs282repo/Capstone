public class Bid{
	private int id;
	
	private String email;
	
	private int price;

	public Bid(){
		id = -1;
		email = null;
		price = -1; 
	}
	public Bid(int id, String email, int price){
		this.id = id;
		this.email = email;
		this.price = price;
	}
	public int getId(){
		return id;
	}
	public String getEmail(){
		return email;
	}
	public int getPrice(){
		return price;
	}
	
	public void updateBid(int price){
		assert(price > 0);
		this.price = price;
	}
}

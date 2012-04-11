/* file: Auction.java
 * Defines the Auction class, which contains the item being auctioned off.
 *
 * TODO: Decide how bids are associated with it.
 */

public class Auction{
	/* The unique id of the auction */
	private static int id;
	/* The descriptive name of the item */
	private static String name;
	/* Seller's suggested price */
	private static int suggestedPrice;
	/* Seller's description */
	private String des;
	/* Seller's email */
	private String email;
	
	public Auction(){
		id = -1;
		name = null;
		suggestedPrice = -1;
		des = null;
		email = null;
	}
	public Auction(	int id,
			String name,
			int suggestedPrice,
			String des,
			String email){
		if (id < 0 || suggestedPrice < 0){ 
			System.err.println("Bad Input");
			assert(false);
		} else {
			this.id = id;
			this.name = name;
			this.suggestedPrice = suggestedPrice;
			this.des = des;
			this.email = email;
		}
	}
	public int getid(){
		return id;
	}
	public int getSuggestedPrice(){
		return suggestedPrice;
	}
	public String getName(){
		return name;
	}
	public String getDes(){
		return des;
	}
	public String getEmail(){
		return email;
	}
}
		


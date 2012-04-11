/* Associates an Auction object with Bid objects */
import java.util.*;

public class AuctionData{
	private Auction auction;
	
	private ArrayList<Bid> bids;

	boolean ended;

	boolean itemShipped;

	boolean itemReceived;

	public AuctionData(){}

	public AuctionData(Auction auction){
		this.auction = auction;
		this.ended = false;
		this.itemShipped = false;
		this.itemReceived = false;
		bids = new ArrayList<Bid>();
	}
	public void addBid(Bid bid){
		bids.add(bid);
	}
	public void removeBid(Bid bid){
		bids.remove(bid);
	}
	public void setAuctionOver(){
		ended = true;
	}
	public void setAuctionItemSent(){
		itemShipped = true;
	}
	public void setAuctionItemReceived(){
		itemReceived = true;
	}
}

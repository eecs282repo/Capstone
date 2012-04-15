package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Bid extends Model{
	public Long bidid;
	public String email;
	public int price;
	public String password;
	public Long auctionId; //Needed to associate with Auction somehow

	public Bid(){}
	
	public Bid(Long id, String email, int price){
		assert(id > 0);
		assert(price > 0);
		this.bidid = id;
		this.email = email;
		this.price = price;
	}
	public void updateBid(int price){
		assert(price > 0);
		this.price = price;
	}
	public static Bid connect(Long id){
		return find("byBidid", id).first();
	}
}

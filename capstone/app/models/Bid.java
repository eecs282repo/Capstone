package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Bid extends Model{
	public Long bidid;
	public String email;
	public int price;
	public String password;
	public Long auctionid; //Needed to associate with Auction somehow

	public Bid(){}
	
	public Bid(	Long id,
			String email,
			int price,
			String password,
			Long auctionid){
		assert(id > 0);
		assert(price > 0);
		this.bidid = id;
		this.email = email;
		this.price = price;
		this.password = password;
		this.auctionid = auctionid;
	}
	public void updateBid(int price){
		assert(price > 0);
		this.price = price;
	}
	public boolean equals(Bid other){
		if (	this.bidid == other.bidid &&
			this.email.equals(other.email) &&
			this.price == other.price &&
			this.password.equals(other.password) &&
			this.auctionid == other.auctionid){
			
			return true;
		} else {
			return false;
		}
	}
			
	public static Bid connect(Long id){
		return find("byBidid", id).first();
	}
}

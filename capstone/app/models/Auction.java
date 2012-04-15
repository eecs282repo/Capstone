package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Auction extends Model{
	public Long auctionid;
	public String name;
	public int suggestedPrice;
	public String description;
	public String email;
	public String password;

	public Auction(){}
	
	public Auction(	Long id,
			String name,
			int suggestedPrice,
			String description,
			String email){
		assert(id > 0 || suggestedPrice > 0);
		this.auctionid = id;
		this.name = name;
		this.suggestedPrice = suggestedPrice;
		this.description = description;
		this.email = email;
		this.password = password;
	}
	public boolean equals(Auction other){
		if (	other.auctionid != this.auctionid ||
			!(other.name.equals(this.name)) ||
			other.suggestedPrice != this.suggestedPrice ||
			!(other.description.equals(this.description)) ||
			!(other.password.equals(this.password))){
			
			return false;
		} else {
			return true;
		}
	}
	public static Auction connect(Long id){
		return find("byAuctionid", id).first();
	}
}

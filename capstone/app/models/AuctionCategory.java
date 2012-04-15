package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class AuctionCategory extends Model{
	public Long auctionid;
	public Long categoryid;
	
	public AuctionCategory(){}

	public AuctionCategory(Long auctionId, Long categoryId){
		this.auctionid = auctionId;
		this.categoryid = categoryId;
	}
	public static AuctionCategory connect(Long auctionid, Long categoryid){
		return find("byAuctionidAndCategoryid", auctionid, categoryid).first();
	}
}

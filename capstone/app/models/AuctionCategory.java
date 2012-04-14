package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class AuctionCategory extends Model{
	public Long auctionId;
	public Long categoryId;
	
	public AuctionCategory(){}

	public AuctionCategory(Long auctionId, Long categoryId){
		this.auctionId = auctionId;
		this.categoryId = categoryId;
	}
	public static AuctionCategory connect(Long auctionId, Long categoryId){
		return find("byAuctionIdAndCategoryId", auctionId, categoryId);
	}
}

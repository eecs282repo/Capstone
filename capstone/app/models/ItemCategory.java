package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class ItemCategory extends Model{
	public Long itemId;
	public Long categoryId;
	
	public ItemCategory(){}

	public ItemCategory(Long itemId, Long categoryId){
		this.itemId = itemId;
		this.categoryId = categoryId;
	}
	public static ItemCategory connect(Long itemId, Long categoryId){
		return find("byItemIdAndCategoryId",itemId, categoryId).first();
	}
}


package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Item extends Model{
	public Long itemid;
	public String name;

	public Item(){}

	public Item(Long id, String name){
		this.itemid = id;
		this.name = name;
	}
	public static Item connect(Long id, String name){
		return find("byItemidAndName", id, name).first();
	}
}

package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Item extends Model{
	public Long id;
	public String name;

	public Item(){}

	public Item(Long id, String name){
		this.id = id;
		this.name = name;
	}
	public static Item connect(Long id, String name){
		return find("byIdAndName", id, name).first();
	}
}

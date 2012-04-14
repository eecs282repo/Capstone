package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Category extends Model{
	public Long id;
	public String name;

	public Category(){}

	public Category(Long id, String name){
		this.id = id;
		this.name = name;
	}
	public static Category connect(Long id, String name){
		return find("byIdAndName", id, name).first();
	}
}
	

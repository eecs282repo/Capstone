package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Category extends Model{
	public Long catid;
	public String name;

	public Category(){}

	public Category(Long id, String name){
		this.catid = id;
		this.name = name;
	}
	public static Category connect(Long id, String name){
		return find("byCatidAndName", id, name).first();
	}
}
	

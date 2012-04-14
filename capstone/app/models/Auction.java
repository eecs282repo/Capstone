package models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Auction extends Model{
	public Long id;
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
		this.id = id;
		this.name = name;
		this.suggestedPrice = suggested{rice;
		this.description = description;
		this.email = email;
		this.password = password;
	}
	
	public static Auction connect(Long id){
		return find("byId", id).first();
	}
}

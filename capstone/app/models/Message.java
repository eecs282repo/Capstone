package Models;

import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Message extends Model{
	public Long id;
	public String subject;
	public String body;
	public Long bidId;
	
	public Message(){}

	public Message(Long id, String subject, String body, Long bidId){
		this.id = id;
		this.subject = subject;
		this.body = body;
		this.bidId = bidId;
	}
	
	public static Message connect(Long id){
		return find("byId", id).first();
	}
}

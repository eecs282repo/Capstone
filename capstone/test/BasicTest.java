import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	
	@Before
	public void setup(){
		Fixtures.deleteDatabase();
	}
	@Test
	public void createAuction(){
		Long id = new Long("1");
		Auction a = new Auction(	id, 
						"Auction1",
						10,
						"This is a description.",
						"auction1@gmail.com");
		a.save();
		Auction b = Auction.find("byAuctionid", id).first();
		assert(b != null);
		assert(b.equals(a));
	}
	@Test
	public void createBid(){
		Auction a = new Auction(	new Long("1"),
						"Auction1",
						10,
						"This is a description",
						"auction1@gmail.com");
		Long id = new Long("1");
		// Fixtures.deleteDatabase() clears it after each test!!!
		a.save();
		Auction a1 = Auction.find("byAuctionid", id).first();
		Bid b1 = new Bid(	id,
					"bid1@gmail.com",
					10,
					"bid1pass",
					a1.auctionid);
		b1.save();
	}
	@Test
	public void createMultipleBids(){
		Auction a = new Auction(new Long("1"),
					"Auction1",
					10,
					"This is a description.",
					"auction1@gmail.com");
		a.save();
		Bid b = new Bid(	new Long("2"),
					"bid1@gmail.com",
					12,
					"bid1pass",
					a.auctionid);
		b.save();
		b = new Bid(	new Long("1"),
				"bid2@gmail.com",
				13,
				"bid2pass",
				a.auctionid);
		b.save();
		Bid b3 = Bid.find("byBidid", new Long("1")).first();
		Bid b2 = Bid.find("byBidid", new Long("2")).first();
		assert(!b3.equals(b2));
		assert(b3.equals(b));
		assert(b3.email.equals("bid2@gmail.com"));
	}
	@Test
	public void accessMultipleBids(){
		Auction a1 = new Auction(	new Long("1"),
						"Auction1",
						10,
						"This is a description.",
						"auction1@gmail.com");
		a1.save();
		Bid b1 = new Bid(	new Long("1"),
					"bid1@gmail.com",
					10,
					"bid1pass",
					a1.auctionid);
		Bid b2 = new Bid(	new Long("2"),
					"bid2@gmail.com",
					12,
					"bid2pass",
					a1.auctionid);
		b1.save();
		b2.save();
		List<Bid> auctionBids =
			Bid.find("byAuctionid", new Long("1")).fetch();
		assert(auctionBids.size() == 2);
		for (int i = 0; i < auctionBids.size(); i++){
			String email, password;
			Long auctionid, bidid;
			int price;
			email = "bid" + Integer.toString(i + 1) + "@gmail.com";
			password = "bid" + Integer.toString(i + 1) + "pass";
			auctionid = new Long("1");
			bidid = new Long(Integer.toString(i + 1));
			assert(email.equals(auctionBids.get(i).email));
			assert(password.equals(auctionBids.get(i).password));
			assert(auctionid == auctionBids.get(i).auctionid);
			assert(bidid == auctionBids.get(i).bidid);
		}
	}


}

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
					

}

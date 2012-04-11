import java.util.*;

public class Iterface_t
{
	ArrayList<AuctionData> dataArray = new ArrayList<AuctionData>();
	int bidId = 0;
	public static Bid makeBid(){
		Scanner input = new Scanner(System.in);
		Bid bid = new Bid();
		System.out.println("Bidder's Email: ");
		String email = input.nextLine();
		System.out.println("Bidder's price: ");
		String stringPrice = input.nextLine();
		int price = Integer.parseInt(stringPrice);
		bid = new Bid(bidId++, email, price);
		return bid;
	}
		
	public static void addAuction(){
		Scanner input = new Scanner(System.in);
		Auction newAuction = new Auction();
		System.out.println("Creating new AuctionData object");
		System.out.println("What is being sold?");
		String itemName = input.nextLine();
		System.out.println("What is the suggested price? (Positive Only)");
		String p = input.nextLine();
		boolean isInt = false;
		int price = -1;
		while (isInt == false){
			try {
				price = Integer.parseInt(p);
				isInt = true;
			} catch (NumberFormatException e){
				System.out.println("Not a valid integer");
			}
		}
		assert(price != -1);
		System.out.println("Enter a brief multiline description");
		System.out.println("End the description with exactly 'END'" +
					"on its own line");
		String description = "";
		boolean end = false;
		while (input.hasNextLine() && end == false){
			if (input.nextLine() == "END"){
				end = true;
				continue;
			}
			description += input.nextLine();
			description += " ";
		}
		System.out.println("Enter seller's email");
		String email = input.nextLine();
		int id = dataArray.size() + 1;
		newAuction = new Auction(id, itemName, price, description, email);
		AuctionData ad = new AuctionData(newAuction);
		dataArray.add(ad);
		System.out.println("Created new Auction");
		System.out.println("Number of bids: ");
		String stringNumBids = input.nextLine();
		
		this.bidId = 0;
		int numBids = Integer.parseInt(stringNumBids);
		for (int i = 0; i < numBids; i++){
			Bid bid = makeBid();
			ad.addBid(bid);
			}
	}
	/*
	public static void scanText(){
		Scanner input = new Scanner(System.in);
		String in;
		while(input.hasNextLine()){
			in = input.nextLine();
			String parts[] = in.split("\t");



	*/
	public static void announceAuction(Auction auction){
		System.out.println("***Auction***");
		System.out.println("Auction Id: " + auction.getid());
		System.out.println("Auction Item Name: " + auction.getName());
		System.out.println("Auction Description: " + 
			auction.getDes());
		System.out.println("Seller's Email: " + auction.getEmail());
		System.out.println("Suggested Price: " +
			auction.getSuggestedPrice());
	}
	public static void main (String[] args){
		//test1();
		addAuction();
	}
	public static void test1(){
		AuctionData auctionData1 = new AuctionData();
		Auction auction1 = new Auction(	123, "Computer", 100,
						"This is really fancy",
						"someone@gmail.com"
						);
		announceAuction(auction1);
	}
}
			
	

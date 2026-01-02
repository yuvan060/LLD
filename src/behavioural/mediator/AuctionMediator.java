package behavioural.mediator;

public interface AuctionMediator {
    public boolean registerBidder(Bidder bidder);
    public boolean placeBid(Bidder bidder, Double amount);
}

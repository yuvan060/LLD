package behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

public class AuctionRoom implements AuctionMediator{

    List<Bidder> bidders = new ArrayList<>();

    @Override
    public boolean registerBidder(Bidder bidder) {
        //logic to verify bidder
        bidders.add(bidder);
        return true;
    }

    @Override
    public boolean placeBid(Bidder bidder, Double amount) {
        //logic to place bid & notify all bidders
        return true;
    }
}

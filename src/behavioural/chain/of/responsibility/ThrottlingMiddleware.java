package behavioural.chain.of.responsibility;

public class ThrottlingMiddleware extends Middleware{
    @Override
    public boolean check(Request request) {
        //logic to handle throttling
        return super.getNextMiddleWare().check(request);
    }
}

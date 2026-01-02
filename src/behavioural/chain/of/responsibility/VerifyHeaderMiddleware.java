package behavioural.chain.of.responsibility;

public class VerifyHeaderMiddleware extends Middleware{
    @Override
    public boolean check(Request request) {
        //logic to verify header
        return super.getNextMiddleWare().check(request);
    }
}

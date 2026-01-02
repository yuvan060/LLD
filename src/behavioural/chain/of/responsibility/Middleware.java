package behavioural.chain.of.responsibility;

public abstract class Middleware {
    private Middleware nextMiddleWare;

    public void setNextMiddleWare(Middleware nextMiddleWare) {
        this.nextMiddleWare = nextMiddleWare;
    }

    public Middleware getNextMiddleWare() {
        return nextMiddleWare;
    }

    public abstract boolean check(Request request);
}

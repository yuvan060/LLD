package structural.decorator;

interface Response {
    public String data();
}

public interface HttpClient {
    public Response request();
}

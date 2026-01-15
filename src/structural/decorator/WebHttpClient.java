package structural.decorator;

public class WebHttpClient implements HttpClient{

    private String url;

    @Override
    public Response request() {
        return  () -> "Dummy data...";
    }
}

package structural.decorator;

public abstract class WebHttpClientDecorator implements HttpClient{
    WebHttpClient webHttpClient;

    public WebHttpClientDecorator(WebHttpClient webHttpClient) {
        this.webHttpClient = webHttpClient;
    }

    abstract public Response request();
}

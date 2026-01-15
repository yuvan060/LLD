package structural.decorator;

public class SanitizeWebHttpClient extends WebHttpClientDecorator{

    public SanitizeWebHttpClient(WebHttpClient webHttpClient) {
        super(webHttpClient);
    }

    @Override
    public Response request() {
        //logic to sanitize the request
        return super.webHttpClient.request();
    }
}

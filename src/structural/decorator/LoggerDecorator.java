package structural.decorator;

public class LoggerDecorator extends WebHttpClientDecorator{
    public LoggerDecorator(WebHttpClient httpClient) {
        super(httpClient);
    }
    @Override
    public Response request() {
        //logging mechanism
        return super.webHttpClient.request();
    }
}

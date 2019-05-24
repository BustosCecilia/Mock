import com.google.gson.Gson;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.Delay;
import org.mockserver.model.Header;

import java.util.concurrent.TimeUnit;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

//http://localhost:8081/.items/12345

public class Services {

    static MockServerClient mockServer = startClientAndServer(8081);
    static Gson gson;

    public static void consulta(String metodo, String ruta, int codigo,
                                String content, String body, int delay) {
        mockServer.when(
                request().withMethod(metodo)
                        .withPath(ruta)
        ).respond(
                response().withStatusCode(codigo)
                        .withHeader(new Header("Content-Type", content))
                        .withBody(body)
                        .withDelay(new Delay(TimeUnit.MILLISECONDS, delay))
        );

    }


    public static void main(String[] args) {
        //  <scope>test</scope> tenes que sacarle el scope test
        gson = new Gson();
        Item item = new Item(12345);
        User user = new User(21388);

        consulta("GET","/.items/.*",200,"application/json; charset=utf-8",
                gson.toJson(item),100);

        consulta("GET","/.users/.*",200,"application/json; charset=utf-8",
                gson.toJson(user),100);
    }
}

package sistema.cep;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaApi {
    private String url;
    ConsultaApi(String url){
        this.url = url;
    }
    String consultar(){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException error){
            return "erro_runtime";
        } catch (IllegalArgumentException error){
            return "erro_argumento";
        }

    }
}

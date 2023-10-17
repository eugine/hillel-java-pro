package ua.ithillel.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static ua.ithillel.utils.LogUtils.log;

public class HttpClientExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://webhook.site/921eb5fb-60de-41e4-b615-4e5f3ab925cc"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        log(body);

//        simpleParse(response);
        var parsed = objectParse(response);
        log("name: " + parsed.name());
        parsed.movies();

    }

    private static void simpleParse(HttpResponse<String> response) throws JsonProcessingException {
        var parsedMap = objectMapper.readValue(response.body(), Map.class);
        log("Parsed map: " + parsedMap);
        log("Parsed name: " + parsedMap.get("name"));
        log("Parsed movies: " + parsedMap.get("movies"));
    }


    private static MovieResponse objectParse(HttpResponse<String> response) throws JsonProcessingException {
        return objectMapper.readValue(response.body(), MovieResponse.class);
    }

    public record MovieResponse (String name, List<String> movies) {
    }
}

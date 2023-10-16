package ua.ithillel.client;

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

        log(response.body());

//        simpleParse(response);
//        objectParse(response);

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

    @Data
    public static class MovieResponse{
        private String name;
        private List<String> movies;
    }
}

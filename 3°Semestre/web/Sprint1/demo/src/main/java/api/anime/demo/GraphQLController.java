package api.anime.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GraphQLController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/searchAnime/{anime}")
    public ResponseEntity<String> searchAnime(@PathVariable String anime) {
        String url = "https://graphql.anilist.co";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{ \"query\": \"" + GraphQLQuery.QUERY.replace("\n", "\\n") + "\", \"variables\": { \"search\": \"" + anime + "\" } }";
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response;
    }
}


package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AnilistGraphQLQuery {

    public static void main(String[] args) throws IOException {
        String query = """
            query ($search: String) {
              Page(page: 1, perPage: 10) {
                pageInfo {
                  total
                  currentPage
                  lastPage
                  hasNextPage
                  perPage
                }

                media(search: $search, type: ANIME, format_in: TV, status: FINISHED) {
                  id
                  title {
                    romaji
                    english
                  }
                  status
                  endDate {
                    year
                    month
                    day
                  }
                  episodes
                  chapters
                  startDate {
                    year
                    month
                    day
                  }
                  countryOfOrigin
                  genres
                }
              }
            }
            """;

        String searchQuery = "Konosuba"; // Replace this with the search term you want to use

        String requestBody = "{ \"query\": \"" + query.replace("\n", "\\n") + "\", \"variables\": { \"search\": \"" + searchQuery + "\" } }";

        String url = "https://graphql.anilist.co";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (var os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                System.out.println("Response:\n" + response.toString());
            }
        } else {
            System.out.println("Request failed with response code: " + responseCode);
        }
    }
}


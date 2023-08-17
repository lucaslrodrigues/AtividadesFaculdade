package api.anime.demo;

public class GraphQLQuery {
    public static final String QUERY = """
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
}


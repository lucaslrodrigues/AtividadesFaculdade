package com.example.api_assincrona

import retrofit2.Response

class LocalMusicaRepositoryImpl : IMusicaRepository {
    override suspend fun getAll(): Response<List<Musica>> {
        val list = listOf(
            Musica("2024-04-18", 1,
                "Bohemian Rhapsody",
                "https://loremflickr.com/640/480/abstract",
                "A Night at the Opera",
                "Queen"
            ),
            Musica("2024-04-17", 2, "Hotel California", "https://loremflickr.com/640/480/abstract", "Hotel California", "Eagles"),
            Musica(
                "2024-04-16",
                3,
                "Stairway to Heaven",
                "https://loremflickr.com/640/480/abstract",
                "Led Zeppelin IV",
                "Led Zeppelin"
            ),
            Musica("2024-04-15", 4, "Imagine", "https://loremflickr.com/640/480/abstract", "Imagine", "John Lennon"),
            Musica(
                "2024-04-14",
                5,
                "Like a Rolling Stone",
                "https://loremflickr.com/640/480/abstract",
                "Highway 61 Revisited",
                "Bob Dylan"
            ),
            Musica("2024-04-13", 6, "Smells Like Teen Spirit", "https://loremflickr.com/640/480/abstract", "Nevermind", "Nirvana"),
            Musica("2024-04-12", 7, "Hey Jude", "https://loremflickr.com/640/480/abstract", "Hey Jude", "The Beatles"),
            Musica(
                "2024-04-11",
                8,
                "Sweet Child o' Mine",
                "https://loremflickr.com/640/480/abstract",
                "Appetite for Destruction",
                "Guns N' Roses"
            ),
            Musica("2024-04-10", 9, "Let It Be", "https://loremflickr.com/640/480/abstract", "Let It Be", "The Beatles"),
            Musica(
                "2024-04-09",
                10,
                "Wonderwall",
                "https://loremflickr.com/640/480/abstract",
                "(What's the Story) Morning Glory?",
                "Oasis"
            )
        )
        return Response.success(list)
    }
}
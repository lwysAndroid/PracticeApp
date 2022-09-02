package com.example.practiceapp.mainFlow.mainFragment.presentation.data.queries

val getFilmDataQuery: String = """
          query Query(${'$'}filmId: ID) {
            film(filmID: ${'$'}filmId) {
                title
                director
                created
            }
          }
          """.trimMargin()
package com.example.practiceapp.mainFlow.mainFragment.presentation.data.queries

val getAllFilmsQuery: String = """
          query Query {
            allFilms {
                films {
                    title
                    director
                    releaseDate
                    speciesConnection {
                      species {
                        name
                        classification
                        homeworld {
                          name
                        }
                      }
                    }
                }
           }
          }
          """.trimMargin()
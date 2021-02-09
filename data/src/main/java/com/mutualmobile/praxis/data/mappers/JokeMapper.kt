package com.mutualmobile.praxis.data.mappers

import com.example.domainn.entity.Joke
import com.mutualmobile.praxis.data.remote.model.JokeListResponse

/**
 * Created by Vipul Asri on 18/01/21.
 */

fun JokeListResponse.toJokes(): List<Joke> {
  return this.value.map { jokeResponse ->
    Joke(
        jokeResponse.id,
        jokeResponse.joke
    )
  }
}
package com.example.domainn.repository

import com.example.domainn.entity.Joke
import com.example.domainn.utils.SafeResult

interface JokesRepo {

  suspend fun getFiveRandomJokes(): SafeResult<List<Joke>>

}
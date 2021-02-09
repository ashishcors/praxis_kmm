package com.mutualmobile.praxis.data.repository

import com.example.domainn.entity.Joke
import com.example.domainn.repository.JokesRepo
import com.example.domainn.utils.SafeResult
import com.example.domainn.utils.SafeResult.Failure
import com.example.domainn.utils.SafeResult.NetworkError
import com.example.domainn.utils.SafeResult.Success
import com.mutualmobile.praxis.data.mappers.toJokes
import com.mutualmobile.praxis.data.sources.IJokesRemoteSource

/**
 * Created by Vipul Asri on 13/01/21.
 */

class JokesRepoImpl(
  private val remoteSource: IJokesRemoteSource
) : JokesRepo {
  override suspend fun getFiveRandomJokes(): SafeResult<List<Joke>> {
    return when (val result = remoteSource.getFiveRandomJokes()) {
      is Success -> Success(result.data.toJokes())
      is Failure -> result
      NetworkError -> NetworkError
    }
  }

}
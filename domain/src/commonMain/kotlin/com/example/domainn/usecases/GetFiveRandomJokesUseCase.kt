package com.example.domainn.usecases

import com.example.domainn.entity.Joke
import com.example.domainn.repository.JokesRepo
import com.example.domainn.utils.SafeResult
import com.example.domainn.utils.SafeResult.Failure
import com.example.domainn.utils.SafeResult.NetworkError
import com.example.domainn.utils.SafeResult.Success

/**
 * Created by Vipul Asri on 13/01/21.
 */

class GetFiveRandomJokesUseCase(private val jokesRepo: JokesRepo) :
    BaseUseCase<SafeResult<List<Joke>>, Unit> {

  override suspend fun perform(): SafeResult<List<Joke>> {
    return when (val result = jokesRepo.getFiveRandomJokes()) {
      is Success -> Success(result.data)
      is NetworkError -> result
      is Failure -> result
    }
  }

}
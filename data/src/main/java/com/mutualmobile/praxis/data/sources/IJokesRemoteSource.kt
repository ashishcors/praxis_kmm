package com.mutualmobile.praxis.data.sources

import com.example.domainn.utils.SafeResult
import com.mutualmobile.praxis.data.remote.model.JokeListResponse

/**
 * Created by Vipul Asri on 13/01/21.
 */

interface IJokesRemoteSource {
  suspend fun getFiveRandomJokes(): SafeResult<JokeListResponse>
}
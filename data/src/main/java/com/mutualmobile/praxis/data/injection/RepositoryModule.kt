package com.mutualmobile.praxis.data.injection

import com.example.domainn.repository.JokesRepo
import com.mutualmobile.praxis.data.repository.JokesRepoImpl
import com.mutualmobile.praxis.data.sources.IJokesRemoteSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vipul Asri on 13/01/21.
 */

@Module
object RepositoryModule {

  @Provides
  @Singleton
  @JvmStatic
  fun provideJokesRepository(networkSource: IJokesRemoteSource): JokesRepo {
    return JokesRepoImpl(networkSource)
  }

}
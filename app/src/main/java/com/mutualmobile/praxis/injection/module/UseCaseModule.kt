package com.mutualmobile.praxis.injection.module

import com.example.domainn.repository.JokesRepo
import com.example.domainn.usecases.GetFiveRandomJokesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vipul Asri on 13/01/21.
 */

@Module
object UseCaseModule {

  @Provides
  @Singleton
  @JvmStatic
  fun provideGetFiveRandomJokes(repo: JokesRepo): GetFiveRandomJokesUseCase {
    return GetFiveRandomJokesUseCase(repo)
  }

}
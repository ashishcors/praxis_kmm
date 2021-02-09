package com.example.domainn.entity

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

/**
 * Created by Vipul Asri on 18/01/21.
 */

@Parcelize
data class Joke(
  val id: Int,
  val joke: String
) : Parcelable
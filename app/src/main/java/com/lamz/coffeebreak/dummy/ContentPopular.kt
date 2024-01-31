package com.lamz.coffeebreak.dummy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentPopular(
    val name : String,
    val price : String,
    val image : Int
) : Parcelable
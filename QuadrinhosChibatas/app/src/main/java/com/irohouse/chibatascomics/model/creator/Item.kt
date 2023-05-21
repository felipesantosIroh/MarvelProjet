package com.irohouse.chibatascomics.model.creator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val name: String,
    val role: String,
) : Parcelable
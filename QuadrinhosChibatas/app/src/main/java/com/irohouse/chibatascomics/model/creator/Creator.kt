package com.irohouse.chibatascomics.model.creator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Creators(
    val available: Long,
    val items: List<Item>,
    val returned: Long,
) : Parcelable

package com.irohouse.chibatascomics.model.comic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    val id: Int,
    val title: String,
    val modified: String,
    val pageCount: Int,
    val thumbnail: Thumbnail
) : Parcelable
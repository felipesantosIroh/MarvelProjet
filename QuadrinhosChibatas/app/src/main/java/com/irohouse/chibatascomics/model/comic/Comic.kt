package com.irohouse.chibatascomics.model.comic

import android.os.Parcelable
import com.irohouse.chibatascomics.model.creator.Creators
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    val id: Int,
    val title: String,
    val modified: String,
    val pageCount: Int,
    val thumbnail: Thumbnail,
    val creators: Creators
) : Parcelable
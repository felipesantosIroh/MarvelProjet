package com.irohouse.chibatascomics.model.comic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseMarvelApiComics(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
): Parcelable
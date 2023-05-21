package com.irohouse.chibatascomics.model.character

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character (
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail
) : Parcelable {
    override fun toString(): String {
        return name
    }
}
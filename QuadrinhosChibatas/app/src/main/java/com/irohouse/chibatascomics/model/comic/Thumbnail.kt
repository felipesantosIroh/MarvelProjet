package com.irohouse.chibatascomics.model.comic

import android.os.Parcelable
import com.irohouse.chibatascomics.util.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
class Thumbnail (

    var path: String? = null,
    var extension: String? = null

) : Parcelable  {
    fun fullPath() = "${path}/${Constants.MarvelApi.IMAGE_PATH}.${extension}"
}




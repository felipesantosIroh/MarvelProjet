package com.irohouse.chibatascomics.model.comic

data class Comic(

    val id: Int,
    val title: String,
    val modified: String,
    val pageCount: Int,
    val thumbnail: Thumbnail

)
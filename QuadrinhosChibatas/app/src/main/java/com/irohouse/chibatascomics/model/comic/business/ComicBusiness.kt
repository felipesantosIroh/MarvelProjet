package com.irohouse.chibatascomics.model.comic.business

import com.irohouse.chibatascomics.model.comic.repository.ComicRepository

class ComicBusiness {
    private val repo by lazy {
        ComicRepository()
    }

    suspend fun getComics(characterId: Int) = repo.getComics(characterId)
}
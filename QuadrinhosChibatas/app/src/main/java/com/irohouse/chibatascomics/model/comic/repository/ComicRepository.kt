package com.irohouse.chibatascomics.model.comic.repository

import android.util.Log
import com.irohouse.chibatascomics.api.ApiService
import com.irohouse.chibatascomics.api.ResponseApi

class ComicRepository {
    suspend fun getComics(characterId: Int): ResponseApi {
        return try {
            val response = ApiService.marvelApi.comics(characterId)
            if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                ResponseApi.Error(":(")
            }
        } catch (exception: Exception) {
            Log.i("COMICS", "getComics: ${exception.toString()}")
            ResponseApi.Error(":(")
        }
    }
}
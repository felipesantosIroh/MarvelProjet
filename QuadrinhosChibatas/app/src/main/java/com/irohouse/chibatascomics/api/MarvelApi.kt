package com.irohouse.chibatascomics.api

import com.irohouse.chibatascomics.model.character.ResponseMarvelApiCharacters
import com.irohouse.chibatascomics.model.comic.ResponseMarvelApiComics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters/{characterId}/comics")
    suspend fun comics(@Path("characterId") characterId: Int): Response<ResponseMarvelApiComics>

    @GET("characters?limit=100")
    suspend fun characters(@Query("orderBy") orderBy: String = "name"): Response<ResponseMarvelApiCharacters>
}
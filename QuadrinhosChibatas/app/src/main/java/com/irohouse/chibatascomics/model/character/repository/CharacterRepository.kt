package com.irohouse.chibatascomics.model.character.repository

import android.util.Log
import com.irohouse.chibatascomics.api.ApiService
import com.irohouse.chibatascomics.api.ResponseApi

class CharacterRepository {

    suspend fun getCharacters(): ResponseApi{
        return try{
            val response = ApiService.marvelApi.characters()
            if (response.isSuccessful){
                ResponseApi.Success(response.body())
            } else{
                ResponseApi.Error(":(")
            }
        } catch (exception: Exception){
            ResponseApi.Error(":(")
        }
    }
}
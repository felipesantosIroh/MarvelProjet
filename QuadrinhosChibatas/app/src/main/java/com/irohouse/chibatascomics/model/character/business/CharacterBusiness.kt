package com.irohouse.chibatascomics.model.character.business

import com.irohouse.chibatascomics.model.character.repository.CharacterRepository

class CharacterBusiness {

    private val repo by lazy { CharacterRepository() }

    suspend fun getCharacters() = repo.getCharacters()
}
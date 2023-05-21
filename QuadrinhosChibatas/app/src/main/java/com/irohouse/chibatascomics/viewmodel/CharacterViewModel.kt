package com.irohouse.chibatascomics.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irohouse.chibatascomics.api.ResponseApi
import com.irohouse.chibatascomics.model.character.ResponseMarvelApiCharacters
import com.irohouse.chibatascomics.model.character.business.CharacterBusiness
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    private val business = CharacterBusiness()
    var resultLiveData: MutableLiveData<ResponseMarvelApiCharacters> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getCharacters() {
        viewModelScope.launch{
            when(val response = business.getCharacters()){
                is ResponseApi.Success -> {
                    resultLiveData.postValue(response.data as ResponseMarvelApiCharacters)
                }
                is ResponseApi.Error -> {
                    messageLiveData.postValue(response.message)
                }
            }
        }
    }

}
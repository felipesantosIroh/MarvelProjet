package com.irohouse.chibatascomics.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irohouse.chibatascomics.api.ResponseApi
import com.irohouse.chibatascomics.model.comic.ResponseMarvelApiComics
import com.irohouse.chibatascomics.model.comic.business.ComicBusiness
import kotlinx.coroutines.launch

class ListComicsViewModel : ViewModel() {
    var business = ComicBusiness()
    var resultLiveData: MutableLiveData<ResponseMarvelApiComics> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getComics(characterId: Int) {
        viewModelScope.launch {
            when (val response = business.getComics(characterId)) {
                is ResponseApi.Success -> {
                    resultLiveData.postValue(response.data as ResponseMarvelApiComics)
                }
                is ResponseApi.Error -> {
                    messageLiveData.postValue(response.message)
                }
            }
        }
    }
}
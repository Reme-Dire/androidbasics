package com.example.retrofit.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.repository.WikiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    val wikiUiState: MutableLiveData<Int> = MutableLiveData()
    private val repository: WikiRepository = WikiRepository()



    fun getHits(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val serverResp = repository.hitCountCheck(name)
            wikiUiState.value = serverResp.query.searchinfo.totalhits
        }
    }
}

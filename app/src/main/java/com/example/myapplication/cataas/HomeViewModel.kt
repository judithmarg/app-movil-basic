package com.example.myapplication.cataas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Cat
import com.example.repository.CataasRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class HomeViewModel: ViewModel() {
    sealed class HomeUIState {
        class Loaded(val list: List<Cat>): HomeUIState()
    }
    val state : LiveData<HomeUIState>
        get() = _state
    private var _state = MutableLiveData<HomeUIState>()
    fun loadCats() {
        val repository = CataasRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val listCataas = repository.getList()
            withContext(Dispatchers.Main) {
                _state.value = HomeUIState.Loaded(listCataas)
            }
        }
    }
}
package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var counter = 0
    val cadena: LiveData<String>
        get() = _cadena
    private val _cadena = MutableLiveData<String>()

    fun increment() {
        _cadena.value =(counter++).toString()
    }
}
package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.Book
import com.example.data.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel: ViewModel() {
    val list : LiveData<List<Book>>
        get() = _list
    private val _list = MutableLiveData<List<Book>>()
    fun getBooks(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {

            val repository = BookRepository(context)
            repository.insert(Book("the best seller: Android"))
            val lista = repository.getListBooks()
            lista.forEach {
                Log.d("DBTEST", "Id book = ${it.id}, Title: ${it.title}")
            }
            withContext(Dispatchers.Main) {
                _list.value = lista
            }

            //falta un cambio al hilo main
        }

//        _list.value = listOf(
//            Book("Libro1"),
//            Book("Caperucita Roja"),
//            Book("Megalodon"),
//            Book("Nemo"),
//            Book("Swan Princess"),
//        )
    }
}
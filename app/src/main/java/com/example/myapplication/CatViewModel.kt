package com.example.myapplication

import android.content.Context
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.Cat
import com.example.data.CatRepository
import com.example.network.CatResponseDto
import com.example.network.CataasLocalDataSource
import com.example.network.CataasRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatViewModel: ViewModel() {
    val list : LiveData<List<Cat>>
        get() = _list
    private val _list = MutableLiveData<List<Cat>>()

    val listInternet : LiveData<List<CatResponseDto>>
        get() = _listInternet
    private val _listInternet = MutableLiveData<List<CatResponseDto>>()

    fun getAllCats(dataSource: CataasRemoteDataSource,context: Context){
        val repository = CatRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            try{
                val response = dataSource.getCatResponse()
                withContext(Dispatchers.Main) {
                    _listInternet.value = response
                }
            val storedCats = repository.getListCats()
            val newCats = response.filter { remoteCat ->
                storedCats.none { storedCat -> storedCat.id.toString() == remoteCat._id }
                }.map { newCat ->
                    Cat(
                        newCat._id,
                        newCat.mimetype,
                        newCat.tags?.joinToString(",") ?:"",
                        newCat.size?:0L
                    )
                }
                repository.insertAll(storedCats)

            } catch (e: Exception) {
                Log.e("hola", "error")
//                var localSource = CataasLocalDataSource(repository)
//                withContext(Dispatchers.Main) {
//                    _list.value = localSource.getCatResponse()
//                }

            }
        }

    }
}
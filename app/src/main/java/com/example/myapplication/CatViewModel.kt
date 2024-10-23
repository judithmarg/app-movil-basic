package com.example.myapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.Cat

class CatViewModel: ViewModel() {
//    val list : LiveData<List<Cat>>
//        get() = _list
//    private val _list = MutableLiveData<List<Cat>>()

//    val listInternet : LiveData<List<CatResponseDto>>
//        get() = _listInternet
//    private val _listInternet = MutableLiveData<List<CatResponseDto>>()
//
//    fun getAllCats(dataSource: CataasRemoteDataSource,context: Context){
//        val repository = CatRepository(context)
//        CoroutineScope(Dispatchers.IO).launch {
//            try{
//                val response = dataSource.getCatResponse()
//                withContext(Dispatchers.Main) {
//                    _listInternet.value = response
//                }
//            val storedCats = repository.getListCats()
//            val newCats = response.filter { remoteCat ->
//                storedCats.none { storedCat -> storedCat.id.toString() == remoteCat._id }
//                }.map { newCat ->
//                    Cat(
//                        newCat._id,
//                        newCat.mimetype,
//                        newCat.tags?.joinToString(",") ?:"",
//                        newCat.size?:0L
//                    )
//                }
//                repository.insertAll(storedCats)
//
//            } catch (e: Exception) {
//                Log.e("hola", "error")
////                var localSource = CataasLocalDataSource(repository)
////                withContext(Dispatchers.Main) {
////                    _list.value = localSource.getCatResponse()
////                }
//
//            }
//        }
//
//    }
    val state : LiveData<CatStateUI>
        get() = _state
    private var _state = MutableLiveData<CatStateUI>()

    sealed class CatStateUI {
        object Loading: CatStateUI()
        data class Error(val message: String): CatStateUI()
        data class Successful(val list: List<Cat>): CatStateUI()
        object InternetConexion: CatStateUI()
    }

    private val catRepository = com.example.repository.CatRepository()
    fun fetchData(context: Context){
        if(!isConexion(context)) {
            _state.value = CatStateUI.Error("no tiene conexion a internet")
        } else {
            _state.value = CatStateUI.Loading
            val list = catRepository.fetchData()
            _state.value = CatStateUI.Successful(list)
        }

    }

    fun isConexion(context: Context): Boolean {
        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false


            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false


            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true


                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true


                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

}
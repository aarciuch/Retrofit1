package art.com.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitViewModel : ViewModel() {
    private val RVM= "RETROFITVIEWMODEL"

    private var _response : MutableLiveData<String> = MutableLiveData()
    val response : LiveData<String>
        get() = _response

    init {
        Log.i(RVM, "RetrofitViewModel init")
        getMarsRealEstateProperties()

    }

    override fun onCleared() {
        super.onCleared()
        Log.i(RVM, "RetrofitViewModel onCleared")
    }

    private fun getMarsRealEstateProperties() {
        //_response.value = "Set the Mars API Response here!"
        MarsApi.retrofitService.getProperties().enqueue(
            object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    _response.value = response.body()
                    Log.i(RVM, "${response.message()} ${response.body()}")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    _response.value = "Failure: " + t.message
                }
            }
        )
    }
}
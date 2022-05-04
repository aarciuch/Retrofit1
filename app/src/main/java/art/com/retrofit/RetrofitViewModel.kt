package art.com.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class RetrofitViewModel : ViewModel() {
    private val RVM= "RETROFITVIEWMODEL"

    private var _response : MutableLiveData<String> = MutableLiveData()
    val response : LiveData<String>
        get() = _response

    private val _property = MutableLiveData<MarsProperty>()
    val property : LiveData<MarsProperty>
        get() = _property

    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties : LiveData<List<MarsProperty>>
        get() = _properties

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
        /*MarsApi.retrofitService.getProperties().enqueue(
            //object : Callback<String> {
            object  : Callback<List<MarsProperty>> {
                override fun onResponse(call: Call<List<MarsProperty>>, response: Response<List<MarsProperty>>) {
                    //_response.value = response.body()
                    _response.value  =
                        "Success: ${response.body()?.size} Mars properties retrieved"
                    Log.i(RVM, "${response.message()} ${response.body()}")
                }

                override fun onFailure(call: Call<List<MarsProperty>>, t: Throwable) {
                    _response.value = "Failure: " + t.message
                }
            }
        )*/

        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getProperties()
                _properties.value = MarsApi.retrofitService.getProperties()
                _response.value = "Success: ${listResult.size} Mars properties retrieved"
                if (listResult.size > 0) {
                    _property.value = listResult[0]
                }
            } catch (e : Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}
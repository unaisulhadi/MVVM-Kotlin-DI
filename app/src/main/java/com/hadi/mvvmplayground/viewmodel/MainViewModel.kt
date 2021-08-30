package com.hadi.mvvmplayground.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.hadi.mvvmplayground.R
import com.hadi.mvvmplayground.app.MyApp
import com.hadi.mvvmplayground.data.model.PicsResponse
import com.hadi.mvvmplayground.data.repository.Repository
import com.hadi.mvvmplayground.util.Resource
import com.hadi.mvvmplayground.util.Utils.hasInternetConnection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject
constructor(private val repository: Repository, application: Application) :
    AndroidViewModel(application) {

    private val _picsResponse = MutableLiveData<Resource<PicsResponse>>()
    val picsResponse: LiveData<Resource<PicsResponse>> = _picsResponse


    fun getPictures() = viewModelScope.launch(Dispatchers.IO) {
        _picsResponse.postValue(Resource.Loading())
        try {
            if (hasInternetConnection(getApplication<MyApp>())) {
                val response = repository.getPictures()
                if (response.isSuccessful) {
                    response.body()?.let { resultResponse ->
                        _picsResponse.postValue(Resource.Success(resultResponse))
                    }
                } else {
                    _picsResponse.postValue(Resource.Error(response.message()))
                }
            } else {
                _picsResponse.postValue(Resource.Error("No Internet Connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _picsResponse.postValue(
                    Resource.Error("Network Failure")
                )
                else -> _picsResponse.postValue(
                    Resource.Error("Conversion Error")
                )
            }
        }
    }


    fun getPics() = liveData<Resource<PicsResponse>>(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = repository.getPictures()
            response.body()?.let { pics ->
                if (response.isSuccessful) {
                    emit(Resource.Success(data = pics))
                } else {
                    emit(Resource.Error(message = "Error Occurred!"))
                }
            }

        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Error Occurred!"))
        }
    }

}
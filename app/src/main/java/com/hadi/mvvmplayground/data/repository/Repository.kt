package com.hadi.mvvmplayground.data.repository

import com.hadi.mvvmplayground.data.remote.ApiService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPictures() = apiService.getPictures()

}
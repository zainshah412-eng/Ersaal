package com.example.ersaal.data.remote
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) : BaseDataSource() {



    suspend fun assignDriver(url: String) =
        getResult {
            apiService.assignDriver(url)
        }
}
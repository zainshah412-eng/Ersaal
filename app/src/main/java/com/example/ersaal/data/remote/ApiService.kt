package com.example.ersaal.data.remote

import com.example.ersaal.core.model.assignorder.AssignOrderResponse
import com.example.ersaal.utils.AppConstants
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET
    suspend fun assignDriver(
        @Url url: String
    ): Response<AssignOrderResponse>


}
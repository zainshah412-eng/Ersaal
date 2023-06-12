package com.example.ersaal.data.remote

import com.example.ersaal.utils.LoggerUtils
import com.example.ersaal.utils.Resource
import com.example.ersaal.utils.ErrorUtils
import com.example.ersaal.utils.apierror.ApiError
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            val message = StringBuilder()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }

            val errorRes = ErrorUtils.parseError(response?.errorBody()?.string())
            LoggerUtils.debug("Error", errorRes.toString())
            return error(errorRes)
        } catch (e: Exception) {
            return error(ApiError(e.message!!, true, ""))
        }
    }

    private fun <T> error(message: ApiError): Resource<T> {
        return Resource.error(message)
    }

}
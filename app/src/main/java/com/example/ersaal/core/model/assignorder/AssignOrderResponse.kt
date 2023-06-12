package com.example.ersaal.core.model.assignorder


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class AssignOrderResponse(
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("error")
    var error: Boolean = false,
    @SerializedName("messages")
    var messages: String = "",
//    @SerializedName("data")
//    var `data`: List<Data> = listOf()
) : Parcelable
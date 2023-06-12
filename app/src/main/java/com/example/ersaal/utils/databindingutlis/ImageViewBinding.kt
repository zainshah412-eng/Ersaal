package com.example.ersaal.utils.databindingutlis

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ersaal.R

@BindingAdapter("imageUrl", "placeholderImage", "errorImage", requireAll = false)
fun loadImageFromInternet(
    view: ImageView,
    imageUrl: String,
    placeholderImage: Int,
    errorImage: Int
) {

    val requestOptions: RequestOptions = RequestOptions()
        .error(R.drawable.place_holder)
        .placeholder(R.drawable.place_holder)

    Glide.with(view.context)
        .setDefaultRequestOptions(requestOptions)
        .load(imageUrl)
        .into(view)
}
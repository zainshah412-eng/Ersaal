package com.example.ersaal.core.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ersaal.R
import com.example.ersaal.core.model.assignorder.OtherUsers
import com.example.ersaal.databinding.ItemListOthersBinding

class OtherUsersAdapter(
    private val context: Context,
    private var dataList: ArrayList<OtherUsers>,
) :
    RecyclerView.Adapter<OtherUsersAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemListOthersBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemListOthersBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder)
        {
            val itemAtPos = dataList[position]
            binding.msg.text = itemAtPos.msg
            binding.userName.text = itemAtPos.userName
            binding.upcomingNotication.text = itemAtPos.notification
            binding.time.text = itemAtPos.time
            binding.profile.setImageResource(itemAtPos.UserProfileImg)

        }
    }

}
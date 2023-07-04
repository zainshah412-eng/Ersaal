package com.example.ersaal.core.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ersaal.R
import com.example.ersaal.core.model.assignorder.AssignIcon
import com.example.ersaal.core.model.assignorder.OtherUsers
import com.example.ersaal.core.model.assignorder.RecentUsers
import com.example.ersaal.databinding.ItemListIconsBinding
import com.example.ersaal.databinding.ItemListOthersBinding
import com.example.ersaal.databinding.ItemListRecentsBinding

class AssignIconsAdapter(
    private val context: Context,
    private var dataList: ArrayList<AssignIcon>,
    private var iconClick: IconClickListener,
) :
    RecyclerView.Adapter<AssignIconsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemListIconsBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var isSelected: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            ItemListIconsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("NotifyDataSetChanged", "SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder)
        {
            val itemAtPos = dataList[position]

            if (position == isSelected) {
                binding.img.setColorFilter(ContextCompat.getColor(context, R.color.yellow))
            } else {
                binding.img.setColorFilter(ContextCompat.getColor(context, R.color.white))

            }
            binding.img.setImageResource(itemAtPos.assignIcon)
            binding.img.setOnClickListener {
                iconClick.onIconClick(position, itemAtPos)

            }
        }
    }

    fun selectedPosition(currentPos: Int) {
        isSelected = currentPos
        notifyDataSetChanged()
    }

    interface IconClickListener {
        fun onIconClick(position: Int, itemAtPos: AssignIcon)
    }

}
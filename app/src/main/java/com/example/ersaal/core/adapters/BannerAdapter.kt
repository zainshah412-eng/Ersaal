package com.example.ersaal.core.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.ersaal.databinding.BannerItemBinding
import com.example.ersaal.databinding.ItemListBinding

class BannerAdapter(
    private val context: Context,
    private var dataList: ArrayList<Int>,
) :
    RecyclerView.Adapter<BannerAdapter.BindViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        val rootView =
            BannerItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: BindViewHolder, position: Int) {
        val item = dataList[position]
        viewHolder.itemBinding.image.setImageDrawable(context.getDrawable(item))
    }


    class BindViewHolder(val itemBinding: BannerItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}
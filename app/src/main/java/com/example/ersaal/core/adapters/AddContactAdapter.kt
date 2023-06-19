package com.example.ersaal.core.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.ersaal.core.model.assignorder.AddContacts
import com.example.ersaal.databinding.ItemListAddContactsBinding

class AddContactAdapter(
    private val context: Context,
    private var dataList: ArrayList<AddContacts>,
) :
    RecyclerView.Adapter<AddContactAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemListAddContactsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemListAddContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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
            binding.img.setImageResource(itemAtPos.profileImg)
            binding.name.text = itemAtPos.name
            binding.del.setOnClickListener {
//                deleteItem(position)
            }
        }
    }

    private fun deleteItem(index: Int) {
        dataList.removeAt(index)
        notifyDataSetChanged()
    }


}
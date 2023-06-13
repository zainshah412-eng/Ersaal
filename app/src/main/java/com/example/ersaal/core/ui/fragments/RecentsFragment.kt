package com.example.ersaal.core.ui.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ersaal.R
import com.example.ersaal.core.adapters.OtherUsersAdapter
import com.example.ersaal.core.adapters.RecentAdapter
import com.example.ersaal.core.model.assignorder.OtherUsers
import com.example.ersaal.core.model.assignorder.RecentUsers
import com.example.ersaal.databinding.FragmentRecentsBinding
import com.example.ersaal.databinding.FragmentSchedularBinding


class RecentsFragment : Fragment() {

    private lateinit var _binding: FragmentRecentsBinding
    private var recentAdapter: RecentAdapter? = null
    var recentUsersList: ArrayList<RecentUsers> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecentsBinding.inflate(inflater, container, false)
        return _binding.root
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpOtherUsersRV()
    }
    private fun setUpOtherUsersRV() {
        _binding.rvOthersList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recentUsersList.add(RecentUsers("Bank of Azaadi","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar,"Family"))
        recentUsersList.add(RecentUsers("JACK","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar,"Tours"))
        recentUsersList.add(RecentUsers("Bank of Azaadi","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar,"Office"))
        recentUsersList.add(RecentUsers("JACK","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar,"Family"))
        recentUsersList.add(RecentUsers("Bank of Azaadi","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar,"Tour"))
        recentUsersList.add(RecentUsers("JACK","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar,"Office"))
        recentUsersList.add(RecentUsers("Bank of Azaadi","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar,"Office"))

        recentAdapter = RecentAdapter(requireContext(), recentUsersList)
        _binding.rvOthersList.adapter = recentAdapter
    }

    private fun initView() {

    }

}
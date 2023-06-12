package com.example.ersaal.core.ui.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ersaal.R
import com.example.ersaal.core.adapters.BannerAdapter
import com.example.ersaal.databinding.FragmentHomeBinding
import com.example.ersaal.utils.SpacesItemDecoration

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private lateinit var bannerAdapter: BannerAdapter
    lateinit var layoutManagerPopular: LinearLayoutManager
    var listOfBanner = ArrayList<Int>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        listOfBanner.clear()
        listOfBanner.add(R.drawable.banner1)
        listOfBanner.add(R.drawable.banner2)
        listOfBanner.add(R.drawable.banner3)
        setUpRVForBannerItems(listOfBanner)
    }

    private fun setUpRVForBannerItems(dataList: ArrayList<Int>) {
        //   imagesData = ArrayList<Game>()
        bannerAdapter =
            BannerAdapter(
                requireContext(),
                dataList
            )
        _binding.viewPager.adapter = bannerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //  _binding = null
    }
}
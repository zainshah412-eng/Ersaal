package com.example.ersaal.core.ui.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ersaal.R
import com.example.ersaal.core.adapters.BannerAdapter
import com.example.ersaal.core.ui.activities.OthersActivity
import com.example.ersaal.core.ui.activities.SignUpActivity
import com.example.ersaal.databinding.FragmentHomeBinding
import com.example.ersaal.utils.SpacesItemDecoration
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment(), View.OnClickListener {
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
        _binding.filterCover.setOnClickListener(this)
        _binding.othersWrap.setOnClickListener(this)
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

    private fun filterBottomSheet() {
        val dialog = BottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.bottom_sheet_for_filter)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //  _binding = null
    }

    override fun onClick(p0: View?) {
        when(p0) {
            _binding.filterCover -> {
                filterBottomSheet()
            }
            _binding.othersWrap -> {
                startActivity(Intent(activity, OthersActivity::class.java))
            }
        }
    
    }
}
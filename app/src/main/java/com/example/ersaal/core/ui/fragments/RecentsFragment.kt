package com.example.ersaal.core.ui.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.ersaal.R
import com.example.ersaal.databinding.FragmentRecentsBinding
import com.example.ersaal.databinding.FragmentSchedularBinding


class RecentsFragment : Fragment() {

    private lateinit var _binding: FragmentRecentsBinding

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

    }
    private fun initView() {

    }

}
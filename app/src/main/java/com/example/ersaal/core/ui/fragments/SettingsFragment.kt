package com.example.ersaal.core.ui.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.ersaal.R
import com.example.ersaal.core.ui.activities.BlockedActivity
import com.example.ersaal.core.ui.activities.SignUpActivity
import com.example.ersaal.databinding.FragmentSchedularBinding
import com.example.ersaal.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment(), View.OnClickListener {
    private lateinit var _binding: FragmentSettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return _binding.root
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }
    private fun initView() {
        _binding.blockedBox.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            _binding.blockedBox -> {
                val intent = Intent(requireContext(), BlockedActivity::class.java)
                startActivity(intent)
            }
        }
     }

}
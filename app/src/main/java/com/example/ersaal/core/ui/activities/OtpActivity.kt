package com.example.ersaal.core.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ersaal.R
import com.example.ersaal.databinding.ActivityOtpBinding

class OtpActivity : AppCompatActivity() {
    lateinit var binding:  ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }
    private fun initView(){

    }
}
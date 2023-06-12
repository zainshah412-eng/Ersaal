package com.example.ersaal.core.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ersaal.R
import com.example.ersaal.databinding.ActivitySignInBinding
import com.example.ersaal.databinding.ActivityTermsAndConditionBinding

class TermsAndConditionActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityTermsAndConditionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsAndConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }
    private fun initView(){
        binding.backButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.backButton -> {
                finish()
            }
        }
    }
}
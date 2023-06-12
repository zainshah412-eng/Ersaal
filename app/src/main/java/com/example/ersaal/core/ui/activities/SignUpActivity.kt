package com.example.ersaal.core.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ersaal.R
import com.example.ersaal.databinding.ActivitySignInBinding
import com.example.ersaal.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.termsConditionBox.setOnClickListener(this)
        binding.signInCover.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.signInCover -> {
                val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                startActivity(intent)
            }
            binding.termsConditionBox -> {
                val intent = Intent(this@SignUpActivity, TermsAndConditionActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
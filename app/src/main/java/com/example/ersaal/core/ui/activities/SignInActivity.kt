package com.example.ersaal.core.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ersaal.R
import com.example.ersaal.core.ui.MainActivity
import com.example.ersaal.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }
    private fun initView(){
        binding.termsConditionBox.setOnClickListener(this)
        binding.signUpCover.setOnClickListener(this)
        binding.btnContinue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.signUpCover -> {
                val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
            binding.termsConditionBox -> {
                val intent = Intent(this@SignInActivity, TermsAndConditionActivity::class.java)
                startActivity(intent)
            }
            binding.btnContinue -> {
                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
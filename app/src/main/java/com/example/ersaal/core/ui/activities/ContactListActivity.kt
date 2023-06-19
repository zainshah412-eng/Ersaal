package com.example.ersaal.core.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ersaal.R
import com.example.ersaal.core.adapters.OtherUsersAdapter
import com.example.ersaal.core.model.assignorder.OtherUsers
import com.example.ersaal.databinding.ActivityContactListBinding
import com.example.ersaal.databinding.ActivityOthersBinding
import com.example.ersaal.databinding.ActivitySignInBinding

class ContactListActivity : AppCompatActivity(), View.OnClickListener {
    private var otherUsersAdapter: OtherUsersAdapter? = null
    var otherUsersList: ArrayList<OtherUsers> = ArrayList()
    var folderName: String = ""
    var contacts: String = ""

    lateinit var binding: ActivityContactListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        folderName = intent.getStringExtra("folderName").toString()
        contacts = intent.getStringExtra("Contacts").toString()
        setUpOtherUsersRV()
        initView()
    }

    private fun initView() {
        binding.tvFolder.text = folderName
        binding.backButton.setOnClickListener(this)
    }

    private fun setUpOtherUsersRV() {
        binding.rvOthersList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        otherUsersList.add(
            OtherUsers(
                contacts,
                "Hi, whatsapp...",
                "2:30 pm",
                "12",
                R.drawable.avatar
            )
        )
//        otherUsersList.add(OtherUsers("Bank of Azaadi","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar))
//        otherUsersList.add(OtherUsers("JACK","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar))
//        otherUsersList.add(OtherUsers("Bank of Azaadi","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar))
//        otherUsersList.add(OtherUsers("JACK","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar))
//        otherUsersList.add(OtherUsers("Bank of Azaadi","Hi, whatsapp...","2:30 pm","12",R.drawable.avatar))

        otherUsersAdapter = OtherUsersAdapter(this, otherUsersList)
        binding.rvOthersList.adapter = otherUsersAdapter
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.backButton -> {
                finish()
            }
        }
    }
}
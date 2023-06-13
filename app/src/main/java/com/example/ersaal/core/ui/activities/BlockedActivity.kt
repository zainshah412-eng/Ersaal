package com.example.ersaal.core.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ersaal.R
import com.example.ersaal.core.adapters.BlockedAdapter
import com.example.ersaal.databinding.ActivityBlockedBinding
import com.example.ersaal.utils.SpacesItemDecoration

class BlockedActivity : AppCompatActivity() {
    lateinit var binding : ActivityBlockedBinding
    private lateinit var blockedAdapter: BlockedAdapter
    lateinit var layoutManager: LinearLayoutManager
    var listOfBlocked = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlockedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        listOfBlocked.clear()
        listOfBlocked.add(1)
        listOfBlocked.add(1)
        listOfBlocked.add(1)
        listOfBlocked.add(1)

        layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.blockedRec.layoutManager = layoutManager
        binding.blockedRec.addItemDecoration(SpacesItemDecoration(14))

        setUpRVForBlockedItems(listOfBlocked)
    }

    private fun setUpRVForBlockedItems(dataList: ArrayList<Int>) {
        //   imagesData = ArrayList<Game>()
        blockedAdapter =
            BlockedAdapter(
                this,
                dataList
            )
        binding.blockedRec.layoutManager = layoutManager;
        binding.blockedRec.adapter = blockedAdapter
    }
}
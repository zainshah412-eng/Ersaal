package com.example.ersaal.core.ui.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ersaal.R
import com.example.ersaal.core.adapters.AddContactAdapter
import com.example.ersaal.core.adapters.AssignIconsAdapter
import com.example.ersaal.core.model.assignorder.AddContacts
import com.example.ersaal.core.model.assignorder.AssignIcon
import com.example.ersaal.databinding.ActivityCreateFolderBinding
import com.example.ersaal.utils.ContactData
import com.example.ersaal.utils.retrieveAllContacts


class CreateFolderActivity : AppCompatActivity(), AssignIconsAdapter.IconClickListener,
    View.OnClickListener {
    lateinit var binding: ActivityCreateFolderBinding
    private val REQUEST_CODE_READ_CONTACTS = 17
    private var assignIconAdapter: AssignIconsAdapter? = null
    private var addContactAdapter: AddContactAdapter? = null
    var iconsList: ArrayList<AssignIcon> = ArrayList()
    private var selectedContact: ContactData? = null

    var arrContacts: ArrayList<String> = ArrayList()
    private var itemPosition: Int = -1
    private var contactName: String = ""
    private var contactsList: ArrayList<AddContacts> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateFolderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkPermissionAndShow()
        initView()
        setUpIconsRV()
        setUpOtherContactsRV()
    }

    private fun initView() {
        binding.btnContinue.setOnClickListener(this)
    }


    private fun setUpIconsRV() {
        binding.recyclerView.layoutManager = GridLayoutManager(this, 7)
        iconsList.add(AssignIcon(R.drawable.arrow))
        iconsList.add(AssignIcon(R.drawable.basketball))
        iconsList.add(AssignIcon(R.drawable.bicycle))
        iconsList.add(AssignIcon(R.drawable.call))
        iconsList.add(AssignIcon(R.drawable.camera_))
        iconsList.add(AssignIcon(R.drawable.car_side))
        iconsList.add(AssignIcon(R.drawable.clock))
        iconsList.add(AssignIcon(R.drawable.eye))
        iconsList.add(AssignIcon(R.drawable.gift))
        iconsList.add(AssignIcon(R.drawable.ice_cream))
        iconsList.add(AssignIcon(R.drawable.iron))
        iconsList.add(AssignIcon(R.drawable.kid_bag))
        iconsList.add(AssignIcon(R.drawable.lightbulb_on))
        iconsList.add(AssignIcon(R.drawable.like))
        iconsList.add(AssignIcon(R.drawable.lock))
        iconsList.add(AssignIcon(R.drawable.money_bag))
        iconsList.add(AssignIcon(R.drawable.pizza_slice))
        iconsList.add(AssignIcon(R.drawable.soda))
        iconsList.add(AssignIcon(R.drawable.sort))
        iconsList.add(AssignIcon(R.drawable.store))
        iconsList.add(AssignIcon(R.drawable.suitcase))
        iconsList.add(AssignIcon(R.drawable.trash))
        iconsList.add(AssignIcon(R.drawable.trophy))
        iconsList.add(AssignIcon(R.drawable.tv))
        iconsList.add(AssignIcon(R.drawable.line))
        iconsList.add(AssignIcon(R.drawable.home_ic))
        iconsList.add(AssignIcon(R.drawable.users))
        iconsList.add(AssignIcon(R.drawable.shopping_bag_ic))
        assignIconAdapter = AssignIconsAdapter(this, iconsList, this)
        binding.recyclerView.adapter = assignIconAdapter
    }

    private fun setUpOtherContactsRV() {
//        if (contactsList.size>0){
//            binding.rvContacts.visibility=View.VISIBLE
//            binding.rvContacts.layoutManager = GridLayoutManager(this, 2)
//            contactsList.add(AddContacts(R.drawable.profile, contactName))
//            contactList.add(AddContacts(R.drawable.profile, contactName))
//            contactList.add(AddContacts(R.drawable.profile, contactName))
//            addContactAdapter = AddContactAdapter(this, contactList)
//            binding.rvContacts.adapter = addContactAdapter
        //    }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_READ_CONTACTS) {
            checkPermissionAndShow()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun checkPermissionAndShow() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val contacts: List<ContactData> = retrieveAllContacts(

            )
            val sb = StringBuilder()
            for (contact in contacts) {
                arrContacts.add(contact.name)

//                contactsList.add(contact)
                 contactName=contact.name.toString()

            }
            binding.rvContacts.visibility = View.VISIBLE
            binding.rvContacts.layoutManager = GridLayoutManager(this, 2)
            contactsList.add(AddContacts(R.drawable.profile,contactName))
            addContactAdapter = AddContactAdapter(this,contactsList)
            binding.rvContacts.adapter = addContactAdapter
            addContactAdapter!!.notifyDataSetChanged()


//            contactDataAdapter = ContactDataAdapter(this, R.layout.activity_create_folder, R.id.name, contactsList)
//            binding.edtContacts.setAdapter(contactDataAdapter)
//            binding.edtContacts.onItemClickListener =
//                OnItemClickListener { adapterView, view, pos, id -> //this is the way to find selected object/item
//                    selectedContact = adapterView.getItemAtPosition(pos) as ContactData
//                }
//            contactsList.add(sb.toString())

            var contactAdapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, arrContacts)
            binding.edtContacts.setAdapter(contactAdapter)
            binding.edtContacts.threshold = 2
            Log.e("contactsList", sb.toString())

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_CODE_READ_CONTACTS
            )
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnContinue -> {
                validationCheck()
            }
        }
    }

    private fun validationCheck() {
        if (binding.edtFolderName.text.toString()
                .isNotEmpty() && binding.edtContacts.text.toString().isNotEmpty()
        ) {
            val intent = Intent(this, ContactListActivity::class.java)
            intent.putExtra("folderName", binding.edtFolderName.text.toString())
            intent.putExtra("Contacts", binding.edtContacts.text.toString())
            startActivity(intent)
        }
    }

    override fun onIconClick(position: Int, itemAtPos: AssignIcon) {
        Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()
    }

//    @SuppressLint("NotifyDataSetChanged")
//    override fun onIconClick(position: Int, itemAtPos: AssignIcon, positionOfItem: Int) {
//        itemPosition = positionOfItem
//        val icon = iconsList[positionOfItem]
//        for (value in 0 until icon.assignIcon) {
//            if (value.equals(itemAtPos))
//                itemAtPos.isSelected = !itemAtPos.isSelected
//        }
//        assignIconAdapter!!.notifyDataSetChanged()
//    }
}
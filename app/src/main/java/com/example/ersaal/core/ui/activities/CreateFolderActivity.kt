package com.example.ersaal.core.ui.activities

import com.example.ersaal.R
import com.example.ersaal.databinding.ActivityCreateFolderBinding
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.ersaal.utils.ContactData
import com.example.ersaal.utils.retrieveAllContacts

class CreateFolderActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateFolderBinding
    private val REQUEST_CODE_READ_CONTACTS = 17

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateFolderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkPermissionAndShow()
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
                sb.append(contact.toString())
                sb.append("\n\n")
            }
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show()
            Log.e("contactsList", sb.toString())
//            textView!!.text = sb.toString()
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_CODE_READ_CONTACTS
            )
        }
    }
}
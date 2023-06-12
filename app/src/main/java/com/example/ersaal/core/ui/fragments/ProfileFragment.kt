package com.example.ersaal.core.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.ersaal.databinding.FragmentProfileBinding
import com.example.ersaal.AppApplication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentProfileBinding
  //  private lateinit var user: User
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   user = AppApplication.sessionManager.userDetails
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        inItView()
    }

    private fun inItView() {
//        binding.email.text = user.email
//        binding.version.text = user.firstName + " " + user.lastName
//        binding.potrCode.text = user.phone
//        binding.profileDetail.text = user.username

        binding.logoutButton.setOnClickListener(this)
        binding.editButton.setOnClickListener(this)
        binding.updatePasswordTab.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.logoutButton -> {
                AppApplication.sessionManager.logoutUser()
            }
            binding.editButton -> {
//                val action = ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment()
//                navController.navigate(action)
            }
            binding.updatePasswordTab -> {
//                val action =
//                    ProfileFragmentDirections.actionProfileFragmentToResetPasswordFragment()
//                navController.navigate(action)
            }
        }
    }
}
package com.example.ersaal.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

import com.example.ersaal.core.repo.KitchenManagerRepo
import com.example.ersaal.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KitchenManagertViewModel @Inject constructor(
    private val kitchenManagerRepo: KitchenManagerRepo
) : ViewModel() {
    private val _getProfile = MutableLiveData<Void>()
    private val _getService = MutableLiveData<Void>()
    private val _getOrders = MutableLiveData<String>()
    private val _getOrderDetail = MutableLiveData<String>()
    private val _getOrderAccepted = MutableLiveData<String>()
    private val _getDrivers = MutableLiveData<String>()
    private val _getOrderDelivered = MutableLiveData<String>()
    private val _updatePassword = MutableLiveData<String>()
    private val _assignDriver = MutableLiveData<String>()





    fun getProfile() {
        _getProfile.value
    }
    fun getService() {
        _getService.value
    }



    fun getOrders(url : String) {
        _getOrders.value = url
    }

    fun getOrderDetail(orderId: String) {
        _getOrderDetail.value = orderId
    }

    fun getOrderAccepted(orderId: String) {
        _getOrderAccepted.value = orderId
    }



    fun getDrivers(url: String) {
        _getDrivers.value = url
    }

    fun getOrderDelivered(url: String) {
        _getOrderDelivered.value = url
    }

    fun updatePassword(password: String) {
        _updatePassword.value = password
    }

  fun assignDriver(url: String) {
        _assignDriver.value = url
    }

}
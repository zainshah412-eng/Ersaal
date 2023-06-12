package com.example.ersaal.utils;
import androidx.viewbinding.BuildConfig

class AppConstants {
    companion object {
        val SHOW_CONSOLE_LOGS = BuildConfig.DEBUG

        /**
         * Base and staging URLS
         */
        const val BASE_URL = "https://dev.mybigchicken.co.uk/"

        /**
         * EndPoints
         */
        const val USER_AUTHENTICATE = BASE_URL  + "api/authenticate"
        const val GET_PROFILE = BASE_URL  + "client/profile"
        const val UPDATE_PROFILE = BASE_URL  + "client/profile"
        const val UPDATE_PASSWORD = BASE_URL  + "client/password"
        const val GET_ORDERS_NEW = BASE_URL  + "client/orders/new"
        const val GET_ORDERS_PROCESS = BASE_URL  + "client/orders/process"
        const val GET_ORDERS_CANCEL = BASE_URL  + "client/orders/cancelled"
        const val GET_ORDERS_ON_WAY = BASE_URL  + "client/orders/way"
        const val GET_ORDERS_ON_DELIVERED = BASE_URL  + "client/orders/delivered"
        const val GET_ORDER_DETAIL = BASE_URL  + "client/orderdetails"
        const val GET_ORDER_ACCEPTED = BASE_URL  + "client/accept"
        const val ORDER_CANCELLED = BASE_URL  + "client/cancel"
        const val GET_DRIVERS = BASE_URL  + "client/drivers"
        const val GET_DRIVER_ASSIGNED = BASE_URL  + "client/assigndriver"
        const val GET_ORDER_DELIVERED = BASE_URL  + "client/delivered"
        const val GET_SERVICE_LIST = "https://track4solutions.com/platform/api.php/records/warrentyTable"

    }
}
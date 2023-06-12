package com.example.ersaal.utils;
import java.io.*;
public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No Internet Connection";
        // You can send any message whatever you want from here.
    }
}

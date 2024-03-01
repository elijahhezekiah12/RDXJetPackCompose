package com.example.rdxjetpackcompose.service

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context:Context, val sharedPreferences: SharedPreferences) {
    /*private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)*/

    fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun saveSignedStatus(key:String,value :Boolean){
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getSignedStatus(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }


}
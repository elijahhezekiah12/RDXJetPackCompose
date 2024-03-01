package com.example.rdxjetpackcompose.di

import android.content.Context
import android.content.SharedPreferences


class SharedPreferencesStorage ( private val context: Context) {

    fun sharedPreferencesInject(): SharedPreferences {
        return context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }
}
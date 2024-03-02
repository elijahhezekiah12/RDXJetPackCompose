package com.example.rdxjetpackcompose.ui.theme.credentialsScreen

import androidx.lifecycle.ViewModel
import com.example.rdxjetpackcompose.util.Constants.emailPattern

class credentialsViewModel:ViewModel() {

    fun validateEmail(email:String): Boolean {

            return email.isNotBlank() && emailPattern.matcher(email).matches()
    }
}
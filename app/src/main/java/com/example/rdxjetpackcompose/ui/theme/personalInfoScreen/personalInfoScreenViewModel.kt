package com.example.rdxjetpackcompose.ui.theme.personalInfoScreen

import android.util.Patterns
import androidx.lifecycle.ViewModel

class personalInfoScreenViewModel:ViewModel() {


    fun firstNameisNotEmpty(firstName:String) : Boolean{
          return firstName.isNotEmpty()
    }

    fun lasttNameisNotEmpty(firstName:String) : Boolean{
        return firstName.isNotEmpty()
    }

    fun validateTelephone(telephone:String): Boolean {
        return  telephone.isNotEmpty() && Patterns.PHONE.matcher(telephone).matches()
    }


}
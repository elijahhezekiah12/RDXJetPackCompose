package com.example.rdxjetpackcompose.ui.theme.mainScreen

import android.content.Context

import androidx.lifecycle.ViewModel
import com.example.rdxjetpackcompose.service.PreferencesManager
import com.example.rdxjetpackcompose.util.Constants.EMAIL
import com.example.rdxjetpackcompose.util.Constants.FIRST_NAME
import com.example.rdxjetpackcompose.util.Constants.LAST_NAME
import com.example.rdxjetpackcompose.util.Constants.SIGNED_STATUS
import com.example.rdxjetpackcompose.util.Constants.TELEPHONE

class mainScreenViewModel(
    context: Context,
    val preferencesManager: PreferencesManager
) :ViewModel() {


    //var preferencesManager = PreferencesManager(context)

    fun isUserSigned(isSigned :Boolean):Boolean{
         preferencesManager.saveSignedStatus(SIGNED_STATUS,isSigned)
        return preferencesManager.getSignedStatus(SIGNED_STATUS,true)
    }

    fun setUserFirstName(): String {
        return  preferencesManager.getData(FIRST_NAME,"")
    }

    fun setUserLastName():String? {
        return preferencesManager.getData(LAST_NAME,"")
    }


    fun setUserTelephone(): String? {
       return  preferencesManager.getData(TELEPHONE,"")
    }

    fun setUserEmail(): String? {
        return  preferencesManager.getData(EMAIL,"")
    }
}
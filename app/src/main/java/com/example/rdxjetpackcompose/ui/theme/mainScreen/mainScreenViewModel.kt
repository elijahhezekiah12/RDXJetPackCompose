package com.example.rdxjetpackcompose.ui.theme.mainScreen

import androidx.lifecycle.SavedStateHandle

import androidx.lifecycle.ViewModel
import com.example.rdxjetpackcompose.service.PreferencesManager
import com.example.rdxjetpackcompose.util.Constants.EMAIL
import com.example.rdxjetpackcompose.util.Constants.FIRST_NAME
import com.example.rdxjetpackcompose.util.Constants.LAST_NAME
import com.example.rdxjetpackcompose.util.Constants.SIGNED_STATUS
import com.example.rdxjetpackcompose.util.Constants.TELEPHONE

class mainScreenViewModel(
    val preferencesManager: PreferencesManager,
    val state: SavedStateHandle
) :ViewModel() {

    fun isUserSigned(isSigned :Boolean):Boolean{
         preferencesManager.saveSignedStatus(SIGNED_STATUS,isSigned)
        return preferencesManager.getSignedStatus(SIGNED_STATUS,true)
    }


    fun setUserFirstName(): String {
        return  preferencesManager.getData(FIRST_NAME,"")
    }

    fun saveFirstName(name: String) {
        state[FIRST_NAME] = name
    }

    fun getFirstName(): String? {
        return state.get<String>(FIRST_NAME)
    }


    fun setUserLastName():String {
        return preferencesManager.getData(LAST_NAME,"")
    }

    fun saveLastName(name: String) {
        state[LAST_NAME] = name
    }

    fun getLastName(): String? {
        return state.get<String>(LAST_NAME)
    }


    fun setUserTelephone(): String {
       return  preferencesManager.getData(TELEPHONE,"")
    }

    fun saveTelephone(name: String) {
        state[TELEPHONE] = name
    }

    fun getTelephone(): String? {
        return state.get<String>(TELEPHONE)
    }

    fun setUserEmail(): String {
        return  preferencesManager.getData(EMAIL,"")
    }

    fun saveEmail(name: String) {
        state[EMAIL] = name
    }

    fun getEmail(): String? {
        return state.get<String>(EMAIL)
    }
}
package com.example.rdxjetpackcompose.ui.theme.mainScreen

import androidx.lifecycle.SavedStateHandle

import androidx.lifecycle.ViewModel
import com.example.rdxjetpackcompose.service.PreferencesManager
import com.example.rdxjetpackcompose.util.Constants.EMAIL
import com.example.rdxjetpackcompose.util.Constants.FIRST_NAME
import com.example.rdxjetpackcompose.util.Constants.FIRST_NAME_SAVED_INSTANCE
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

    var firstNameSaved =  preferencesManager.getData(FIRST_NAME,"")
    fun setUserFirstName(firstNameLocal :String): String {
        return   firstNameLocal
    }


    fun saveFirstName(name: String) {
        state[FIRST_NAME_SAVED_INSTANCE] = name
    }


    fun getFirstName(): String? {
        return state.get<String>(FIRST_NAME_SAVED_INSTANCE)
    }

    var lastNameSaved =  preferencesManager.getData(LAST_NAME,"")
    fun setUserLastName(lastNameLocal:String):String {
        return lastNameLocal
    }

    fun saveLastName(name: String) {
        state[LAST_NAME] = name
    }

    fun getLastName(): String? {
        return state.get<String>(LAST_NAME)
    }


    var telephoneSaved =  preferencesManager.getData(TELEPHONE,"")

    fun setUserTelephone(telephoneLocal:String): String {
       return  telephoneLocal
    }

    fun saveTelephone(name: String) {
        state[TELEPHONE] = name
    }

    fun getTelephone(): String? {
        return state.get<String>(TELEPHONE)
    }

    var emailSaved =  preferencesManager.getData(EMAIL,"")

    fun setUserEmail(emailLocal:String): String {
        return  emailLocal
    }

    fun saveEmail(name: String) {
        state[EMAIL] = name
    }

    fun getEmail(): String? {
        return state.get<String>(EMAIL)
    }
}
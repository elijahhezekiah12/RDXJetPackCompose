package com.example.rdxjetpackcompose.model

data class User(
    var firstName: String = "",
    var lastName: String = "",
    var signedIn: Boolean = false,
    var telephone:String="",
    var email :String="",

) {
    fun isNotEmpty(): Boolean {
        return firstName.isNotEmpty() && lastName.isNotEmpty()
    }
}

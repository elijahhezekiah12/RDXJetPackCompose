package com.example.rdxjetpackcompose.util

import java.util.regex.Pattern

object Constants {

    const val EMAIL:String ="USER_EMAIL"

    const val TELEPHONE:String="USER_PHONE"

    const val FIRST_NAME:String="FIRST_NAME"

    const val LAST_NAME:String="LAST_NAME"

    const val SIGNED_STATUS:String="USERS_SIGNED_IN"

    /**
     * Check if the email is valid
     */
    val emailPattern: Pattern by lazy {
        Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,64}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,255}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,}" +
                    ")+"
        )
    }

}
package com.br.childcaretaker.auth

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

open class Authentication(val context: Context) {

    fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
    }

    fun getUser(preferences: SharedPreferences): Map<String, Any?> {
        return mapOf(
            "name" to preferences.all["username"].toString(),
            "password" to preferences.all["password"].toString()
        )
    }

    fun verifyUserLogin(username: String, password: String): Boolean {
        val usernameSaved = getUser(preferences=getSharedPreferences())
        return usernameSaved["name"] == username && password == usernameSaved["password"]
    }
}
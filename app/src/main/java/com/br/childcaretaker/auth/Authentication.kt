package com.br.childcaretaker.auth

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class Authentication {

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
    }

    fun getUser(context: Context): Map<String, Any?> {
        return mapOf(
            "name" to getSharedPreferences(context).all["username"].toString(),
            "password" to getSharedPreferences(context).all["password"].toString()
        )
    }

    fun verifyUserLogin(username: String, password: String, context: Context): Boolean {
        val usernameSaved = getUser(context)
        return usernameSaved["name"] == username && password == usernameSaved["password"]
    }
}
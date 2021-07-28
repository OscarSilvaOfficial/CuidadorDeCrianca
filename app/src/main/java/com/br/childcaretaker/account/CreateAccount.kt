package com.br.childcaretaker.account

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.br.childcaretaker.R
import com.br.childcaretaker.main.MainActivity

class CreateAccount : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val createAccountBtn: Button = findViewById(R.id.createAccountBtn)
        createAccountBtn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.createAccountBtn) {
            val username: EditText = findViewById(R.id.newUsername)
            val password: EditText = findViewById(R.id.newPassword)
            registerAccount(
                username=username.text.toString(),
                password=password.text.toString()
            )
        }
    }

    fun changeActivity(NextPageClass: AppCompatActivity) {
        val nextActivity = Intent(this, NextPageClass::class.java)
        startActivity(nextActivity)
    }

    fun getSharedPreferences(): SharedPreferences {
        return applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
    }

    fun createUser(username: String, password: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences()
        sharedPreferences.edit()
            .putString("username", username)
            .putString("password", password)
            .apply()
    }

    fun registerAccount(username: String, password: String) {
        createUser(
            username=username,
            password=password
        )
        changeActivity(NextPageClass=MainActivity())
    }
}
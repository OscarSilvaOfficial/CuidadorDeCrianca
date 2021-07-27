package com.br.childcaretaker.main

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.br.childcaretaker.CreateAccount
import com.br.childcaretaker.LoggedUser
import com.br.childcaretaker.R

class MainActivity:  AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerListeners()
    }

    override fun onClick(view: View) {
        val selector = AppCompatActivity()
        val id = view.id
        if (id == R.id.loginBtn) {
            val user: EditText = selector.findViewById(R.id.username)
            val pass: EditText = selector.findViewById(R.id.password)
            makeLogin(
                username=user.text.toString(),
                password=pass.text.toString()
            )
        }
        if (id == R.id.createAccountLink) {
            changeActivity(NextPageClass= CreateAccount())
        }
    }

    fun changeActivity(NextPageClass: AppCompatActivity) {
        val nextActivity = Intent(this, NextPageClass::class.java)
        startActivity(nextActivity)
    }

    fun makeLogin(username: String, password: String) {
        val userExists: Boolean = verifyUserLogin(
            username=username,
            password=password
        )
        if (userExists) changeActivity(NextPageClass= LoggedUser())
    }

    fun registerListeners() {
        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener(this)

        val createAccountLink: TextView = findViewById(R.id.createAccountLink)
        createAccountLink.setOnClickListener(this)
    }

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPref", MODE_PRIVATE)
    }

    fun verifyUserLogin(username: String, password: String): Boolean {
        val usernameSaved = getSharedPreferences(applicationContext).all["username"] as CharSequence?
        val passwordSaved = getSharedPreferences(applicationContext).all["password"] as CharSequence?
        return usernameSaved.toString() == username && password == passwordSaved.toString()
    }
}
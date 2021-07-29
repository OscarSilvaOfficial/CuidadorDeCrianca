package com.br.childcaretaker.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.br.childcaretaker.R
import com.br.childcaretaker.account.CreateAccount
import com.br.childcaretaker.auth.Authentication

class MainActivity:  AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: Authentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val elementListeners = arrayOf(R.id.loginBtn, R.id.createAccountLink)
        registerListeners(elementListeners)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.loginBtn) makeLogin(
            username=toStringElement(findViewById(R.id.username)),
            password=toStringElement(findViewById(R.id.password)),
        )
        if (view.id == R.id.createAccountLink) changeActivity(NextPage=CreateAccount())
    }

    fun changeActivity(NextPage: AppCompatActivity) {
        val nextActivity = Intent(this, NextPage::class.java)
        startActivity(nextActivity)
    }

    fun makeLogin(username: String, password: String) {
        auth=Authentication(context=applicationContext)
        val userExists: Boolean = auth.verifyUserLogin(username, password)
        if (userExists) changeActivity(NextPage=LoggedUser())
    }

    fun registerListeners(arrayListeners: Array<Int>) {
        for (listener in arrayListeners) {
            val element: View = findViewById(listener)
            element.setOnClickListener(this)
        }
    }

    fun toStringElement(element: TextView): String {
        return element.text.toString()
    }
}
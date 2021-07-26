package com.br.childcaretaker

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private fun getSharedPreferences(): SharedPreferences {
        return applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences()

        if (sharedPreferences.contains("lastCalc")) {
            loadUser(sharedPreferences)
        }

        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener(this)
    }

    /*
    * Implementar essa função após cadastro de usuário
    * */
    private fun loadUser(sharedPreferences: SharedPreferences) {
        /*val totalValueView: TextView = findViewById(R.id.totalValue)*/
        /*totalValueView.text = sharedPreferences.all["lastLogin"] as CharSequence?*/
    }

    /*
    * Melhorar abstração de seleção de listener
    * */
    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.loginBtn) {
            makeLogin()
        }
    }

    private fun makeLogin() {
        val username: EditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)
    }
}
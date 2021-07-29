package com.br.childcaretaker.auth

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TestAuthentication {

    @Mock
    private lateinit var mockAuth: Authentication

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var prefs: SharedPreferences

    @Before
    fun init() {
        mockAuth = Authentication(context)
        Mockito.`when`(context.getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)).thenReturn(prefs)
        Mockito.`when`(prefs.all).thenReturn(mapOf("username" to "teste", "password" to "teste"))
    }

    @Test
    fun `Test Instance sharedPreferences`(){
        val preferences = mockAuth.getSharedPreferences()
        assert(preferences is SharedPreferences)
    }

    @Test
    fun `Test getUser`(){
        val preferences = mockAuth.getUser(prefs)
        assert(preferences["name"] == "teste" && preferences["password"] == "teste")
    }

    @Test
    fun `Test if user exists`(){
        assert(mockAuth.verifyUserLogin("teste", "teste"))
    }

    @Test
    fun `Test if user does not exist`(){
        assert(!mockAuth.verifyUserLogin("teste1", "teste"))
    }
}
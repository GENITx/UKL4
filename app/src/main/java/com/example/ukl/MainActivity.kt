package com.example.ukl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var email: EditText
    private lateinit var sandi: EditText
    private val KEY_EMAIL = "EA"
    private val KEY_PASS = "PP"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.txtUser)
        sandi = findViewById(R.id.txtPassword)

        val btnLoginActivity: Button =
            findViewById(R.id.login)
        btnLoginActivity.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        try {
            val username = email.text.toString()
            val sandi = sandi.text.toString()
            if (username.isNotBlank() && sandi.isNotBlank()) {
                when (v.id) {
                    R.id.login -> {
                        val moveIntent = Intent(this@MainActivity, Home::class.java)
                        moveIntent.putExtra(KEY_EMAIL,username)
                        moveIntent.putExtra(KEY_PASS,sandi)
                        startActivity(moveIntent)
                    }
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "PLEASE PUT YOUR EMAIL & PASS",
                    Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception){
            Toast.makeText(applicationContext, "PLEASE PUT YOUR EMAIL & PASS", Toast.LENGTH_SHORT).show()
        }
    }
}
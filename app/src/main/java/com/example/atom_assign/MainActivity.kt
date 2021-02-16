package com.example.atom_assign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val user = Firebase.auth.currentUser
            if (user != null) {
                val intent = Intent(this@MainActivity, Home::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this@MainActivity, logIn::class.java)
                startActivity(intent)
                finish()
            }

        }, 1000)

    }
}
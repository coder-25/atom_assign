package com.example.atom_assign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Home : AppCompatActivity() {
    lateinit var logOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpUID()

        logOut.setOnClickListener(){
            Unit
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@Home, logIn()::class.java))
            finish()
        }


    }
    private fun setUpUID(){
        logOut= findViewById(R.id.bttnLog)
    }
}
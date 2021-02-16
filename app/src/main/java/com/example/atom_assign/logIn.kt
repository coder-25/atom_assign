package com.example.atom_assign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

import android.widget.TextView
import android.widget.Toast
import kotlin.math.log

class logIn : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var logIn: Button
    lateinit var register: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        setUpUID();
        logIn.setOnClickListener {
            Unit
            val mail=email.text.toString()
            val pass=password.text.toString()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(mail, pass)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val intent= Intent(this@logIn, Home()::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(
                            this@logIn,
                            "Please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }

        register.setOnClickListener {
            Unit
            val intent= Intent(this@logIn,
                Register()::class.java)
            startActivity(intent)
        }

    }

    private fun setUpUID(){
        email= findViewById(R.id.email)
        password=findViewById(R.id.password)
        logIn= findViewById(R.id.login)
        register=findViewById(R.id.register)
    }
}

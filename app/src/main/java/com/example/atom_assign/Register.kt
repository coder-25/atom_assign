package com.example.atom_assign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Register : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var register: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUpUID()

        register.setOnClickListener(){
            Unit
            val mail=email.text.toString()
            val pass=password.text.toString()
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val firebaseUser: FirebaseUser=task.result!!.user!!
                        val intent= Intent(this@Register, Home()::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(
                            this@Register,
                            "An unexpected error occurred(intent id is null )",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
        }
    }
    private fun setUpUID(){
        email= findViewById(R.id.regisEmail)
        password=findViewById(R.id.regisPassword)
        register=findViewById(R.id.bttnRegister)
    }
}
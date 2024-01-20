package com.manish.yogacharaapp.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.manish.yogacharaapp.R
import com.manish.yogacharaapp.model.User

class RegisterActivity : AppCompatActivity() {

    lateinit var txtlog: TextView
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etPass: EditText
    lateinit var etCPass: EditText
    lateinit var etPhone: EditText
    lateinit var btnRegister: Button
    lateinit var sp: SharedPreferences
    lateinit var auth: FirebaseAuth
    lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtlog=findViewById(R.id.txtlog)
        etCPass=findViewById(R.id.etConfirmPassword)
        etEmail=findViewById(R.id.etUsername)
        etPass=findViewById(R.id.etPassword)
        etName=findViewById(R.id.etName)
        etPhone=findViewById(R.id.etNumber)
        btnRegister=findViewById(R.id.btnregister)

        auth= Firebase.auth
        sp=getSharedPreferences("yoga", Context.MODE_PRIVATE)
        val isLoggedIn =sp.getBoolean("isLoggedIn",false)
        if(isLoggedIn){
            val intent= Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        txtlog.setOnClickListener{
            val intent= Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnRegister.setOnClickListener {
            var fieldChecked=isAllFieldChecked()
            var checkpass=checkPass()

            val email=etEmail.text.toString()
            val pass=etPass.text.toString()
            val name=etName.text.toString()
            val phone=etPhone.text.toString()
            if(fieldChecked && checkpass)
            {
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
                    if(it.isSuccessful){
                        Toast.makeText(this@RegisterActivity,"Registration Successfully", Toast.LENGTH_SHORT)
                            .show()

                        addUserToDatabase(name,email,phone,auth.currentUser?.uid!!)

                        val intent= Intent(this@RegisterActivity, ProfileActivity::class.java)
                        sp.edit().putBoolean("isLoggedIn",true).apply()
                        startActivity(intent)
                        finish()

                    }
                    else{
                        Toast.makeText(this@RegisterActivity,"Registration failed", Toast.LENGTH_SHORT)
                            .show()
                    }

                }
            }
        }

    }

    fun isAllFieldChecked():Boolean{

        if(etName.length()==0 || etEmail.length()==0|| etPass.length()==0 || etCPass.length()==0 || etPhone.length()==0)
        {
            if(etName.length()==0)
            {
                etName.error="Name is required"
            }
            if(etEmail.length()==0)
            {
                etEmail.error="Email is required"
            }
            if(etPass.length()==0)
            {
                etPass.error="Password is must"
            }
            if(etCPass.length()==0){
                etCPass.error="Enter Password to Confirm"
            }
            if(etPhone.length()==0){
                etPhone.error="Enter your Phone number"

            }
            Toast.makeText(this@RegisterActivity,"Enter Your credentials", Toast.LENGTH_SHORT).show()
            return false
        }
        else{
            return true
        }
    }

    fun checkPass():Boolean{
        val cpass1=etCPass.text.toString()
        val pass1=etPass.text.toString()
        if(cpass1==pass1)
        {
            return true
        }
        else
        {
            etCPass.error="Confirm password and password not matched"
            return false
        }
    }
    private fun addUserToDatabase(name:String,email:String,phone:String,uid:String) {
        dbRef = FirebaseDatabase.getInstance().getReference()
        dbRef.child("yoga").child("user").child(uid).setValue(User(name, email,phone, uid))
    }
}
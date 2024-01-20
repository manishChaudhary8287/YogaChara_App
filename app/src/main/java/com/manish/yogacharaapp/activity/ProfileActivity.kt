package com.manish.yogacharaapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.manish.yogacharaapp.R
import com.manish.yogacharaapp.model.User
import com.manish.yogacharaapp.model.Profile

class ProfileActivity : AppCompatActivity() {

    lateinit var name:TextView
    lateinit var email:TextView
    lateinit var phone:TextView
    lateinit var age:EditText
    lateinit var weight:EditText
    lateinit var height:EditText
    lateinit var btnSave:Button
    lateinit var dbRef:DatabaseReference
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        name=findViewById(R.id.ProfileName)
        email=findViewById(R.id.ProfileEmail)
        phone=findViewById(R.id.ProfilePhone)
        age=findViewById(R.id.ProfileAge)
        weight=findViewById(R.id.ProfileWeight)
        height=findViewById(R.id.ProfileHeight)
        btnSave=findViewById(R.id.btnSave)

        dbRef=FirebaseDatabase.getInstance().getReference()
        auth= FirebaseAuth.getInstance()
        dbRef.child("yoga").child("user").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (postsnapshot in snapshot.children){
                    val listDetails= postsnapshot.getValue(User::class.java)
                   if(listDetails!=null){
                       if(listDetails.uid== auth.currentUser?.uid)
                       {
                           name.text=listDetails.name
                           email.text=listDetails.email
                           phone.text=listDetails.phone
                           break;
                       }
                   }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //  Nothing to do here.Used in further process
            }
        })

        btnSave.setOnClickListener {
            val name1=name.text.toString()
            val email1=email.text.toString()
            val phone1=phone.text.toString()
            val age1=age.text.toString()
            val weight1=weight.text.toString()
            val height1=height.text.toString()
            val uid= auth.currentUser?.uid

            if(checkAllField() && uid != null){
                addFullDetails(name1,email1,phone1,age1,weight1,height1,uid)
                val intent=Intent(this@ProfileActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    private fun addFullDetails(name:String,email:String,phone:String,age:String,weight:String,height:String,uid:String){
        dbRef.child("profile").child("user").child(uid).setValue(Profile(name,email,phone,age,weight,height,uid))
    }
    private fun checkAllField():Boolean {
        if (age.length() == 0 || weight.length() == 0 || height.length() == 0) {
            if (age.length() == 0) {
                age.error = "Enter age"
            }
            if (weight.length() == 0) {
                weight.error = "Enter weight"
            }
            if (height.length() == 0) {
                height.error = "Enter height"
            }
            return false
        }
        else
        {
            return true
        }
    }
}
package com.manish.yogacharaapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.manish.yogacharaapp.R
import com.manish.yogacharaapp.model.Profile

class ProfileFragment : Fragment() {

    lateinit var name: TextView
    lateinit var email: TextView
    lateinit var phone: TextView
    lateinit var age: TextView
    lateinit var weight: TextView
    lateinit var height: TextView
    lateinit var dbRef: DatabaseReference
    lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_profile, container, false)

        name=view.findViewById(R.id.ProfileFragName)
        email=view.findViewById(R.id.ProfileFragEmail)
        phone=view.findViewById(R.id.ProfileFragPhone)
        age=view.findViewById(R.id.ProfileFragAge)
        weight=view.findViewById(R.id.ProfileFragWeight)
        height=view.findViewById(R.id.ProfileFragHeight)

        dbRef= FirebaseDatabase.getInstance().getReference()
        auth= FirebaseAuth.getInstance()
        dbRef.child("profile").child("user").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(postnapshot in snapshot.children){
                    val details=postnapshot.getValue(Profile::class.java)
                    if(details!=null){
                        if(details.uid== auth.currentUser?.uid){
                            name.text=details.name
                            email.text=details.email
                            phone.text=details.phone
                            age.text=details.age
                            weight.text=details.weight
                            height.text=details.height
                            break;
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                //Nothing to do here for now.use it in future.
            }

        })

        return view
    }
}
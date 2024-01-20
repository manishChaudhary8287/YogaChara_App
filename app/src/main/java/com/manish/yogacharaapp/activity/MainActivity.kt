package com.manish.yogacharaapp.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.manish.yogacharaapp.fragment.MeditationFragment
import com.manish.yogacharaapp.fragment.ProfileFragment
import com.manish.yogacharaapp.R
import com.manish.yogacharaapp.fragment.BMIFragment
import com.manish.yogacharaapp.fragment.DietFragment
import com.manish.yogacharaapp.fragment.ExerciseFragment
import com.manish.yogacharaapp.fragment.HistoryFragment
import com.manish.yogacharaapp.fragment.VideoFragment
import com.manish.yogacharaapp.fragment.YogasanasFragment

class MainActivity : AppCompatActivity() {

    lateinit var menubar: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var sp: SharedPreferences
    lateinit var mauth:FirebaseAuth
    var previousMenuItem: MenuItem?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menubar=findViewById(R.id.MainNavigationView)
        drawerLayout=findViewById(R.id.drawerLayout)
        toolbar=findViewById(R.id.MainToolbar)
        mauth= FirebaseAuth.getInstance()

        sp=getSharedPreferences("yoga", Context.MODE_PRIVATE)
        setUpToolbar()
        openProfile()

        val actionBarDrawerToggle=ActionBarDrawerToggle(this@MainActivity,drawerLayout,
            R.string.navOpen,
            R.string.navClose
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        menubar.setNavigationItemSelectedListener {

            if(previousMenuItem!=null){
                previousMenuItem!!.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it

            when(it.itemId){
                R.id.ProfileMenu ->{
                    openProfile()
                    drawerLayout.closeDrawers()
                }
                R.id.ExerciseMenu ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.mainFrameLayout,
                        YogasanasFragment()
                    ).commit()
                    supportActionBar?.title="Exercise  and  Meditation"
                    drawerLayout.closeDrawers()
                }
                R.id.DietChartMenu ->
                {
                    supportActionBar?.title="Diet Plan"
                    supportFragmentManager.beginTransaction().replace(
                        R.id.mainFrameLayout,
                        DietFragment()
                    ).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.BMIMenu->
                {
                    supportActionBar?.title="BMI"
                    supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout,BMIFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.HistoryMenu->{
                    supportActionBar?.title="History"
                    supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout,HistoryFragment()).commit()
                    drawerLayout.closeDrawers()
                }
                R.id.logoutMenu->{
                    mauth.signOut()
                    val intent= Intent(this@MainActivity,LoginActivity::class.java)
                    sp.edit().clear().apply()
                    finish()
                    startActivity(intent)
                }
            }
            return@setNavigationItemSelectedListener true
        }

    }

    private fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="YogaChara Application"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun openProfile(){
        supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout, ProfileFragment()).commit()
        supportActionBar?.title="Your Profile"
        menubar.setCheckedItem(R.id.ProfileMenu)
    }
    private fun openExercise(){
        supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout,YogasanasFragment()).commit()
        supportActionBar?.title="Exercise  and  Meditation"
        menubar.setCheckedItem(R.id.ExerciseMenu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.mainFrameLayout)
        when(frag){
            is VideoFragment -> openExercise()
            !is ProfileFragment -> openProfile()
            else -> super.onBackPressed()
        }
    }
}
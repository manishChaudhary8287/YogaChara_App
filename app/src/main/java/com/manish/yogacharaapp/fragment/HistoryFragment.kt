package com.manish.yogacharaapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.manish.yogacharaapp.R
import java.util.Calendar

class HistoryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_history, container, false)

        val calendar = Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_MONTH)
        val todayString=year.toString()+""+month.toString()+""+day.toString()

        val sharedPreferences = requireActivity().getSharedPreferences("Pref",0)
        val currentDay=sharedPreferences.getBoolean(todayString,false)

        if(!currentDay){
            Toast.makeText(activity as Context,"Checked in for Today.",Toast.LENGTH_SHORT).show()
            val editor=sharedPreferences.edit()
            editor.putBoolean(todayString,true)
            editor.apply()
        }
        return view
    }


}
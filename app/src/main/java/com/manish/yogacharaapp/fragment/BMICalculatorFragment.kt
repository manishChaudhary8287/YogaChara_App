package com.manish.yogacharaapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

import com.manish.yogacharaapp.R

class BMICalculatorFragment : Fragment() {

    lateinit var etWeight:EditText
    lateinit var etHeight:EditText
    lateinit var btnBMiCalculate: Button
    lateinit var BMILayout:LinearLayout
    lateinit var yourBMI:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_b_m_i_calculator, container, false)

        etWeight=view.findViewById(R.id.enterWeightBMI)
        etHeight=view.findViewById(R.id.enterHeightBMI)
        btnBMiCalculate=view.findViewById(R.id.btnCalcBMI)
        BMILayout=view.findViewById(R.id.BMICalcLayout)
        yourBMI=view.findViewById(R.id.YourBMI)

        btnBMiCalculate.setOnClickListener {
            if(checkWeightAndHeight()){
                val weight1=etWeight.text.toString().toFloat()
                var height1=etHeight.text.toString().toFloat()
                height1=height1/100
                val temp=height1*height1
                val bmi=(weight1/temp).toInt()
                yourBMI.text= bmi.toString()
                BMILayout.visibility=View.VISIBLE
                if(bmi>=0 && bmi<=18){
                    yourBMI.setTextColor(getResources().getColor(R.color.underweight))

                }else if (bmi>18 && bmi<=24){
                    yourBMI.setTextColor(getResources().getColor(R.color.healthy))
                }
                else if (bmi>24 && bmi<=29){
                    yourBMI.setTextColor(getResources().getColor(R.color.overweight))

                }
                else if (bmi>29 && bmi<=39){
                    yourBMI.setTextColor(getResources().getColor(R.color.obese))

                }
                else if (bmi>39 && bmi<=65){
                    yourBMI.setTextColor(getResources().getColor(R.color.ExtremeObese))

                }
            }
            etWeight.text.clear()
            etHeight.text.clear()
        }


        return view
    }

    private fun checkWeightAndHeight():Boolean{
        if(etWeight.length()==0||etHeight.length()==0){
            if(etWeight.length()==0){
                etWeight.error="Enter weight"
            }
            if(etHeight.length()==0){
                etHeight.error="Enter Height"
            }
            return false
        }
        else{
            return true
        }
    }

}
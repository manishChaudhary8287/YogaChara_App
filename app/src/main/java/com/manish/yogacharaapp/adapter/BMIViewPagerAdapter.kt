package com.manish.yogacharaapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.manish.yogacharaapp.fragment.BMICalculatorFragment
import com.manish.yogacharaapp.fragment.BMIChartFragment
import com.manish.yogacharaapp.fragment.ExerciseFragment
import com.manish.yogacharaapp.fragment.MeditationFragment
import com.manish.yogacharaapp.fragment.WeightGainFragment
import com.manish.yogacharaapp.fragment.WeightLossFragment

class BMIViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BMICalculatorFragment()
            1 -> BMIChartFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "BMI Calculator"
            1 -> "BMI Chart"
            else -> null
        }
    }
}
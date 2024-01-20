package com.manish.yogacharaapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.manish.yogacharaapp.fragment.ExerciseFragment
import com.manish.yogacharaapp.fragment.MeditationFragment
import com.manish.yogacharaapp.fragment.NonVegGainFragment
import com.manish.yogacharaapp.fragment.VegGainFragment
import com.manish.yogacharaapp.fragment.WeightGainFragment
import com.manish.yogacharaapp.fragment.WeightLossFragment

class GainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> VegGainFragment()
            1 -> NonVegGainFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Veg Diet"
            1 -> "Non-Veg Diet"
            else -> null
        }
    }
}
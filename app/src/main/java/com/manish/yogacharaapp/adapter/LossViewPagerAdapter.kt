package com.manish.yogacharaapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.manish.yogacharaapp.fragment.ExerciseFragment
import com.manish.yogacharaapp.fragment.MeditationFragment
import com.manish.yogacharaapp.fragment.NonVegLossFragment
import com.manish.yogacharaapp.fragment.VegLossFragment
import com.manish.yogacharaapp.fragment.WeightGainFragment
import com.manish.yogacharaapp.fragment.WeightLossFragment

class LossViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> VegLossFragment()
            1 -> NonVegLossFragment()
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
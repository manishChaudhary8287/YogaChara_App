package com.manish.yogacharaapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.manish.yogacharaapp.R
import com.manish.yogacharaapp.adapter.BMIViewPagerAdapter

class BMIFragment : Fragment() {

    lateinit var tabLayout : TabLayout
    lateinit var viewPager : ViewPager
    lateinit var viewPagerAdapter: BMIViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_b_m_i, container, false)

        tabLayout=view.findViewById(R.id.tabLayoutBMI)
        viewPager=view.findViewById(R.id.viewPagerBMI)
        viewPagerAdapter=BMIViewPagerAdapter(requireActivity().supportFragmentManager)
        viewPager.adapter=viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        return view
    }
}
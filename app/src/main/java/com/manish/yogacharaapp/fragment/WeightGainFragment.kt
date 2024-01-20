package com.manish.yogacharaapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.manish.yogacharaapp.R
import com.manish.yogacharaapp.adapter.GainViewPagerAdapter

class WeightGainFragment : Fragment() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager:ViewPager
    lateinit var viewPagerAdapter: GainViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_weight_gain, container, false)

        tabLayout=view.findViewById(R.id.tabLayoutGain)
        viewPager=view.findViewById(R.id.viewPagerGain)
        viewPagerAdapter=GainViewPagerAdapter(requireActivity().supportFragmentManager)
        viewPager.adapter=viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        return view
    }
    override fun onResume() {
        viewPagerAdapter.notifyDataSetChanged()
        super.onResume()
    }
}
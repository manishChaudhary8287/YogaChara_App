package com.manish.yogacharaapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.manish.yogacharaapp.R
import com.manish.yogacharaapp.adapter.ExerciseViewPagerAdapter


class YogasanasFragment : Fragment() {

    lateinit var tabLayout : TabLayout
    lateinit var viewPager : ViewPager
    lateinit var viewPagerAdapter:ExerciseViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_yoagasanas, container, false)

        tabLayout=view.findViewById(R.id.tabLayout)
        viewPager=view.findViewById(R.id.viewPager)
        viewPagerAdapter = ExerciseViewPagerAdapter(requireActivity().supportFragmentManager)
        viewPager.adapter=viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        return view
    }
}
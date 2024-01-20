package com.manish.yogacharaapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.manish.yogacharaapp.R


class MeditationFragment : Fragment() {

    lateinit var txtBeginners:TextView
    lateinit var txt7steps:TextView
    lateinit var txtAvoidMistakes:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_meditation, container, false)

        txtBeginners=view.findViewById(R.id.txtBeginners)
        txt7steps=view.findViewById(R.id.txt7steps)
        txtAvoidMistakes=view.findViewById(R.id.txtAvoidMistakes)

        val videoFragment=VideoFragment()

        txtBeginners.setOnClickListener {
            val bundle=Bundle()
            bundle.putInt("beg",R.raw.beg)
            bundle.putString("beg1","beg")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }
        txt7steps.setOnClickListener {
            val bundle=Bundle()
            bundle.putInt("steps",R.raw.step)
            bundle.putString("step1","steps")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }
        txtAvoidMistakes.setOnClickListener {
            val bundle=Bundle()
            bundle.putInt("avoid",R.raw.avoid)
            bundle.putString("avoid1","avoid")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }


        return view
    }


}
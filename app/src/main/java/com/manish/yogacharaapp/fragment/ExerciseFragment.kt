package com.manish.yogacharaapp.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import com.manish.yogacharaapp.R
import java.io.PushbackInputStream


class ExerciseFragment : Fragment() {

    lateinit var txtWarmup:TextView
    lateinit var txtSurya:TextView
    lateinit var txtPlank:TextView
    lateinit var txtPushups:TextView
    lateinit var txtFaceYoga:TextView
    lateinit var txtSquats:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_exercise, container, false)

        txtWarmup=view.findViewById(R.id.txtWarmup)
        txtSurya=view.findViewById(R.id.txtSurya)
        txtPlank=view.findViewById(R.id.txtPlank)
        txtPushups=view.findViewById(R.id.txtpushUps)
        txtFaceYoga=view.findViewById(R.id.txtFaceYoga)
        txtSquats=view.findViewById(R.id.txtSquat)

        val videoFragment=VideoFragment()

        txtWarmup.setOnClickListener {
            val bundle=Bundle()
//            bundle.putInt("warmup",R.raw.warmup_exercise)
            bundle.putString("warm1","warmup")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }
        txtSurya.setOnClickListener {
            val bundle=Bundle()
//            bundle.putInt("surya",R.raw.suryanamaskar)
            bundle.putString("sury1","surya")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }
        txtPlank.setOnClickListener {
            val bundle=Bundle()
//            bundle.putInt("plank",R.raw.plank)
            bundle.putString("plank1","plank")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }
        txtPushups.setOnClickListener {
            val bundle=Bundle()
//            bundle.putInt("pushup",R.raw.pushups)
            bundle.putString("pushup1","pushup")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }
        txtFaceYoga.setOnClickListener {
            val bundle=Bundle()
//            bundle.putInt("face",R.raw.face_yoga)
            bundle.putString("face1","faceyoga")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }
        txtSquats.setOnClickListener {
            val bundle=Bundle()
//            bundle.putInt("squat",R.raw.warmup_exercise)
            bundle.putString("squat1","squat")
            videoFragment.arguments=bundle
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.mainFrameLayout,videoFragment).commit()
            }
        }

        return view
    }
}
package com.manish.yogacharaapp.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.browser.customtabs.CustomTabsClient.getPackageName
import com.manish.yogacharaapp.R
import java.lang.Package.getPackage


class VideoFragment : Fragment() {

    lateinit var txtVideoTitle:TextView
    lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_video, container, false)

        txtVideoTitle=view.findViewById(R.id.txtVideoTitle)
        videoView=view.findViewById(R.id.videoView)

        val bundle=arguments
        if(bundle!=null)
        {
            if(bundle.getString("warm1")=="warmup"){
                txtVideoTitle.text="Warmup Exercise"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.warmup_exercise}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
            else if(bundle.getString("sury1")=="surya"){
                txtVideoTitle.text="Suryanamaskar"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.suryanamaskar}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
            else if(bundle.getString("plank1")=="plank"){
                txtVideoTitle.text="Plank"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.plank}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
            else if(bundle.getString("pushup1")=="pushup"){
                txtVideoTitle.text="PushUps"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.pushups}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
            else if(bundle.getString("face1")=="faceyoga"){
                txtVideoTitle.text="Face Yoga"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.face_yoga}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
            else if(bundle.getString("squat1")=="squat"){
                txtVideoTitle.text="Squats"
            val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.squat}")
            videoView.setVideoURI(uri)
            videoView.start()
        }
            else if(bundle.getString("beg1")=="beg"){
                txtVideoTitle.text="Meditation for Beginners"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.beg}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
           else if(bundle.getString("step1")=="steps"){
                txtVideoTitle.text="7 steps to do Meditation"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.step}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
           else if(bundle.getString("avoid1")=="avoid"){
                txtVideoTitle.text="Avoid mistakes during Meditation"
                val uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.avoid}")
                videoView.setVideoURI(uri)
                videoView.start()
            }
        }

        return view
    }

}
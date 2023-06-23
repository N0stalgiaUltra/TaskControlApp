package com.example.taskcontrol.uxui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskcontrol.R

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragmentteste.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragmentteste : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}
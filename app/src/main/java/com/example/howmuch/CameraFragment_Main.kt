package com.TAVE10thProject.HowMuch

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.howmuch.databinding.FragmentMainCameraBinding

class CameraFragment_Main :Fragment(){
    lateinit var binding: FragmentMainCameraBinding
    //private lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainCameraBinding.inflate(layoutInflater)
    }
}
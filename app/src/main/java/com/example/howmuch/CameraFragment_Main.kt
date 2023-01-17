package com.example.howmuch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.howmuch.databinding.FragmentMainCameraBinding

class CameraFragment_Main :Fragment(){
    lateinit var binding: FragmentMainCameraBinding
    //private lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainCameraBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainCameraBinding.inflate(inflater,container,false)

        //token = arguments?.getString("token").toString()
        //userPK = arguments?.getString("userPK").toString()

        return binding.root
    }
}
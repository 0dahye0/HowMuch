package com.TAVE10thProject.HowMuch

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.TAVE10thProject.HowMuch.databinding.FragmentMainHomeBinding

class HomeFragment_Main: Fragment() {
    lateinit var binding: FragmentMainHomeBinding
    //private lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainHomeBinding.inflate(layoutInflater)
    }
}
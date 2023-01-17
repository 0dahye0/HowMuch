package com.example.howmuch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.howmuch.databinding.FragmentMainMypageBinding

class MyPageFragment_Main :Fragment(){
    lateinit var binding: FragmentMainMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainMypageBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMypageBinding.inflate(inflater,container,false)

        //token = arguments?.getString("token").toString()
        //userPK = arguments?.getString("userPK").toString()

        return binding.root
    }
}
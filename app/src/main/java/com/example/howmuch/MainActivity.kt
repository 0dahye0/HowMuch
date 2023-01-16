package com.TAVE10thProject.HowMuch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.howmuch.MyPageFragment_Main
import com.example.howmuch.R
import com.example.howmuch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val token = intent.getStringExtra("token")
        val userPK = intent.getStringExtra("userPK")
        val userId = intent.getStringExtra("userId")
        val userImg = intent.getStringExtra("userImg")

        Log.d("MAIN/INTENT",token+' '+userPK)

        
        initBottomNavigation(userPK.toString(),token.toString(),userId.toString(),userImg.toString())
    }


    private fun initBottomNavigation(userPK:String,token:String,userId:String,userImg:String) {

        val homeFragment = HomeFragment_Main()
        var bundle = Bundle()
        bundle.putString("token",token)
        bundle.putString("userPK",userPK)
        //homeFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, homeFragment)
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item ->
            when(item.itemId) {
                R.id.page_home -> {
                    var bundle = Bundle()
                    bundle.putString("token",token)
                    bundle.putString("userPK",userPK)

                    //homeFragment.arguments = bundle

                    supportFragmentManager.beginTransaction().replace(R.id.main_frm , homeFragment).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.page_camera -> {
                    val cameraFragment = CameraFragment_Main()
                    var bundle = Bundle()
                    bundle.putString("token",token)
                    bundle.putString("userPK",userPK)

                    //FeedFragment.arguments = bundle

                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, cameraFragment).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.page_mypage -> {
                    val mypageFragment=MyPageFragment_Main()
                    var bundle = Bundle()
                    bundle.putString("userId",userId)
                    bundle.putString("userImg",userImg)
                    bundle.putString("token",token)

                    //SettingFragment.arguments = bundle

                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, mypageFragment).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}
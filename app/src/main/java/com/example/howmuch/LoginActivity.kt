package com.example.howmuch

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.howmuch.databinding.ActivityLoginBinding

class LoginActivity:AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    var DB:DBHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        DB= DBHelper(this)

        binding.loginButton.setOnClickListener{
            val user=binding.loginIdEnrollTv!!.text.toString()
            val pass=binding.loginPasswordEnrollTv!!.text.toString()
            if(user==""||pass=="") Toast.makeText(
                this,
                "회원정보를 전부 입력해주세요",
                Toast.LENGTH_SHORT
            ).show() else{
                val checkUserpass=DB!!.checkUserpass(user,pass)
                if(checkUserpass==true){
                    Toast.makeText(this,"로그인 되었습니다",Toast.LENGTH_SHORT).show()
                    val intent= Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"회원정보가 존재하지 않습니다",Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.tvSignup.setOnClickListener{
            val loginIntent=Intent(this,SignupActivity::class.java)
            startActivity(loginIntent)
        }
    }
}
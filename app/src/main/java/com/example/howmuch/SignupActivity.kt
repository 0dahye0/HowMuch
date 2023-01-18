package com.example.howmuch

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.howmuch.databinding.ActivitySignupBinding

class SignupActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    var DB:DBHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        DB= DBHelper(this)

        binding.signupDoned.setOnClickListener {
            val user=binding.signupEmail.text.toString()
            val pass=binding.signupPw.text.toString()
            val repass=binding.signupPwCheck.text.toString()
            val nickname=binding.signupNickname.text.toString()
            if(user=="" || pass=="" || repass==""||nickname=="") Toast.makeText(
                this,
                "회원정보를 전부 입력해주세요",
                Toast.LENGTH_SHORT
            ).show() else{
                if(pass==repass){
                    val checkUseremail=DB!!.checkUseremail(user)
                    if(checkUseremail==false){
                        val insert=DB!!.insertData(user,pass,nickname)
                        if(insert==true){
                            Toast.makeText(
                                this,
                                "가입되었습니다",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent=Intent(applicationContext,LoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(
                                this,
                                "비밀번호가 일치하지 않습니다",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }else{
                        Toast.makeText(
                            this,
                            "이미 가입된 회원입니다",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }else{
                    Toast.makeText(this,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
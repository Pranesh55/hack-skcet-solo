package com.example.chatapplication.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatapplication.R
import com.example.chatapplication.RegisterActivity
import com.example.chatapplication.UserData
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListeners()
    }
    fun initListeners(){
        tv_signup.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}
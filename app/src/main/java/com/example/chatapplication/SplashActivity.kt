package com.example.chatapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.chatapplication.login.LoginActivity

class SplashActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var isLoggedIn=false

        var user=SharedPreferenceManager.getInstance(this)?.user
        if(user==null){
            Handler().postDelayed({startActivity(Intent(this, LoginActivity::class.java))},5000)
        }else {
            Handler().postDelayed({ startActivity(Intent(this, MainActivity::class.java)) }, 5000)
        }
    }
}
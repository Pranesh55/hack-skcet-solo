package com.example.chatapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity:AppCompatActivity() {
    var individualCategories=ArrayList<String>()
    var classes=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initViews()
        initListeners()
    }
    fun initViews(){

        individualCategories.add("Select Individual category")
        individualCategories.add("Teacher")
        individualCategories.add("Student")
        classes.add("Select Class")
        classes.add("CSE-A")
        classes.add("CSE-B")
        classes.add("CSE-C")
        sp_category.adapter=ArrayAdapter(this,R.layout.spinner_layout,individualCategories)

    }
    fun initListeners(){
        sp_category.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               if(individualCategories[p2]=="Student"){
                   sp_class.visibility=View.VISIBLE
                   sp_class.adapter=ArrayAdapter(this@RegisterActivity,R.layout.spinner_layout,classes)
               }else{
                   sp_class.visibility=View.GONE
               }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btn_login.setOnClickListener {
            var userData=UserData().apply {
                id=1
                name=tie_name.text.toString()
                email=tie_email.text.toString()
                userType=sp_category.selectedItem.toString()
            }
            SharedPreferenceManager(this)!!.userLogin(userData)
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}
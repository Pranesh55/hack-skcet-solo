package com.example.chatapplication

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.solver.Cache
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{

    private lateinit var appBarConfiguration: AppBarConfiguration
var myRunnable:Runnable?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        Log.d("Username","NAme is "+SharedPreferenceManager(this).user?.name.toString())
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = drawer_layout
        val navView: NavigationView = nav_view
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragmentListSubjects
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)
        navView.itemIconTintList=null
        var headerView=navView.getHeaderView(0)
        var nameView=headerView.findViewById<TextView>(R.id.tv_welcome)
        nameView.text="Welcome back, "+SharedPreferenceManager(this).user!!.name



//        myRunnable = Runnable {
//            val manager =
//                applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//            val runningTasks = manager.getRunningTasks(1)
//
//            if (runningTasks != null && runningTasks.size > 0) {
//                val topActivity = runningTasks[0].topActivity
//                if (!topActivity!!.packageName.startsWith("com.example.chatapplication")) {
//                    Log.i("Top Activity", topActivity!!.packageName)
////                    if (Ca.isForceHome()) {
//                    val intent = Intent(this, SplashActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    startActivity(intent)
////                    }
//                }
//                Handler().postDelayed(myRunnable!!, 500)
//            }
//        }
//        Handler().postDelayed(myRunnable!!,1000)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var navController=findNavController(R.id.nav_host_fragment_content_main)
        when(item.itemId){
            R.id.logout -> {
                SharedPreferenceManager(this).logout()
                startActivity(Intent(this, RegisterActivity::class.java))
                finish()
            }

            R.id.about->{
                navController.navigate(R.id.aboutFragment)
            }
            R.id.nav_home->{
                navController.navigate(R.id.fragmentListSubjects)
            }
        }
        drawer_layout.closeDrawers()
        return false
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if(false) {
            super.onBackPressed()
        }

    }

    override fun onPause() {
        super.onPause()

    }

    }

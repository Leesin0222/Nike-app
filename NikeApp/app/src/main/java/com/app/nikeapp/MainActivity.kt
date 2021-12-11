package com.app.nikeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottom_nav: BottomNavigationView
    private lateinit var loginFragment: LoginFragment
    private lateinit var homeFragment: HomeFragment
    private lateinit var hartFragment: HartFragment
    private var lastTimeBackPressed:Long=-1000

    private val onBottomNavItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_login -> {

                    loginFragment = LoginFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragments_frame, loginFragment).commit()
                }
                R.id.menu_home -> {
                    homeFragment = HomeFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragments_frame, homeFragment).commit()
                }
                R.id.menu_hart -> {

                    hartFragment = HartFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragments_frame, hartFragment).commit()
                }
            }
            true

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //레이아웃과 연결
        setContentView(R.layout.activity_main)
        bottom_nav = findViewById(R.id.bottom_nav)

        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment)
            .commit()
    }
    // 이전 버튼 두 번 눌러서 종료하기
    override fun onBackPressed() {
        // (현재 버튼 누른 시간-이전에 버튼 누른 시간) <=1.5초일 때 동작
        if(System.currentTimeMillis()-lastTimeBackPressed<=1500)
            finish()
        lastTimeBackPressed=System.currentTimeMillis()
        Toast.makeText(this,"이전 버튼을 한 번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()
    }

    class SplashActivity : AppCompatActivity() {

        val SPLASH_VIEW_TIME: Long = 2000 //2초간 스플래시 화면을 보여줌 (ms)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            Handler().postDelayed({ //delay를 위한 handler
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, SPLASH_VIEW_TIME)
        }
    }

}
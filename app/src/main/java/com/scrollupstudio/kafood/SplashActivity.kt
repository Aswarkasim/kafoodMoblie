package com.scrollupstudio.kafood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.scrollupstudio.kafood.data.database.PrefsManager
import com.scrollupstudio.kafood.ui.home.HomeActivity
import com.scrollupstudio.kafood.ui.login.LoginActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    lateinit var prefsManager: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        prefsManager = PrefsManager(this)
        Handler().postDelayed({
            if(prefsManager.prefsIsLogin){
                when(prefsManager.prefsRole){
                    "user" ->{
                        startActivity<HomeActivity>()
                    }
                    "warung"->{
                        startActivity<MainActivity>()
                    }
                }
            }else{
                startActivity<LoginActivity>()
            }
            finish()
        },1200)

    }
}
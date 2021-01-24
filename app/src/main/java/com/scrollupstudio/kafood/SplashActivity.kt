package com.scrollupstudio.kafood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.scrollupstudio.kafood.ui.login.LoginActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity<LoginActivity>()
            finish()
        },1200)

    }
}
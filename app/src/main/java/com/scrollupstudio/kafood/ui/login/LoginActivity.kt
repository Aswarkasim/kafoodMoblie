package com.scrollupstudio.kafood.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scrollupstudio.kafood.MainActivity
import com.scrollupstudio.kafood.R
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startActivity<MainActivity>()
    }
}
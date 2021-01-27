package com.scrollupstudio.kafood.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scrollupstudio.kafood.R
import kotlinx.android.synthetic.main.activity_resgister.*
import org.jetbrains.anko.startActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resgister)

        btn_register_register.setOnClickListener {
            startActivity<NextStepActivity>()
        }


    }
}
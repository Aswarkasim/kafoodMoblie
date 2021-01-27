package com.scrollupstudio.kafood.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scrollupstudio.kafood.R
import com.scrollupstudio.kafood.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_next_step.*
import org.jetbrains.anko.startActivity

class NextStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_step)

        btn_submit_register.setOnClickListener {
            startActivity<HomeActivity>()
        }
    }
}
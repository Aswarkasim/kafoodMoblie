package com.scrollupstudio.kafood.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.scrollupstudio.kafood.R
import com.scrollupstudio.kafood.data.model.register.RegisterResponse
import com.scrollupstudio.kafood.ui.register.next.NextStepActivity
import kotlinx.android.synthetic.main.activity_resgister.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import kotlin.random.Random

class RegisterActivity : AppCompatActivity() , RegisterContract.View{

    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resgister)

        presenter = RegisterPresenter(this)


    }

    override fun initActivity() {

    }
//        val randomNumber = (1..10000000).random()

    override fun initListener() {
        btn_register_register.setOnClickListener {
            var id_user = (1..10000000).random()
            var username = et_username_register.text.trim()
            var password = et_password_register.text

            if (username.isNullOrEmpty()){
                et_username_register.error = getString(R.string.isi_data_dengan_benar)
                et_username_register.requestFocus()
                return@setOnClickListener
            }else if(password.isNullOrEmpty()){
                et_password_register.error = getString(R.string.isi_data_dengan_benar)
                et_password_register.requestFocus()
                return@setOnClickListener
            }else if (password.toString() != et_re_password_register.text.toString()){
                et_re_password_register.error = "Korfirmasi password tidak sama"
                et_re_password_register.requestFocus()
            }else{
                presenter.register(id_user.toString(),username.toString(), password.toString())
            }
        }
    }

    override fun onLoading(loading: Boolean) {
        when(loading){
            true -> {
                pb_register.visibility = View.VISIBLE
                btn_register_register.visibility = View.GONE
            }
            false -> {
                pb_register.visibility = View.GONE
                btn_register_register.visibility = View.VISIBLE
            }

        }
    }

    override fun onResult(registerResponse: RegisterResponse) {
        if(registerResponse.error){
            onMessage(registerResponse.message)
        }else{
        onMessage(registerResponse.message)
            startActivity<NextStepActivity>()
            finish()
        }
    }

    override fun onMessage(message: String) {
        toast(message)
    }
}
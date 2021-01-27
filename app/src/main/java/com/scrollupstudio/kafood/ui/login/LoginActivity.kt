package com.scrollupstudio.kafood.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.scrollupstudio.kafood.MainActivity
import com.scrollupstudio.kafood.R
import com.scrollupstudio.kafood.data.database.PrefsManager
import com.scrollupstudio.kafood.data.model.login.LoginResponse
import com.scrollupstudio.kafood.ui.home.HomeActivity
import com.scrollupstudio.kafood.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_next_step.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var presenter: LoginPresenter
    lateinit var prefManager: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       presenter = LoginPresenter(this)
        prefManager = PrefsManager(this)
    }

    override fun initActivity() {

    }

    override fun initListener() {
        btn_login_login.setOnClickListener {
            presenter.doLogin(et_username_login.text.toString(), et_password_login.text.toString())
        }

        btn_register_login.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }

    override fun onLoading(loading: Boolean) {
        when(loading){
            true->{
                pb_login.visibility = View.VISIBLE
                btn_register_login.visibility = View.GONE
                btn_login_login.visibility = View.GONE
            }
            false->{
                pb_login.visibility = View.GONE
                btn_register_login.visibility = View.VISIBLE
                btn_login_login.visibility = View.VISIBLE
            }
        }
    }

    override fun onResult(loginResponse: LoginResponse) {
        when(loginResponse.error){
            true ->{
                toast("Gagal login")
            }
            false->{
                presenter.setPrefs(prefManager, loginResponse.user!!)
                when(loginResponse.user.role){
                    "user" -> {
                        startActivity<HomeActivity>()
                    }
                    "warung" -> {
                        startActivity<MainActivity>()
                    }
                }
                finish()
            }
        }
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
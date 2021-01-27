package com.scrollupstudio.kafood.ui.login

import android.os.Message
import com.scrollupstudio.kafood.data.database.PrefsManager
import com.scrollupstudio.kafood.data.model.login.DataLogin
import com.scrollupstudio.kafood.data.model.login.LoginResponse

interface LoginContract {

    interface Presenter {
        fun doLogin(username: String, password: String)
        fun setPrefs(prefManager: PrefsManager, dataLogin: DataLogin)
    }

    interface View{
        fun initActivity()
        fun initListener()
        fun onLoading(loading: Boolean)
        fun onResult(loginResponse: LoginResponse)
        fun showMessage(message: String)
    }
}
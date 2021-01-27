package com.scrollupstudio.kafood.ui.login

import com.scrollupstudio.kafood.data.database.PrefsManager
import com.scrollupstudio.kafood.data.model.login.DataLogin
import com.scrollupstudio.kafood.data.model.login.LoginResponse
import com.scrollupstudio.kafood.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (val view: LoginContract.View): LoginContract.Presenter{

    init {
        view.initActivity()
        view.initListener()
        view.onLoading(false)
    }

    override fun doLogin(username: String, password: String) {
        view.onLoading(true)
        ApiService.auth.login(username, password)
            .enqueue(object : Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    view.onLoading(false)
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    view.onLoading(false)
                    if(response.isSuccessful){
                        val loginResponse: LoginResponse? = response.body()

                        if (loginResponse != null) {
                            view.onResult(loginResponse)
                        }
                    }
                }

            })
    }

    override fun setPrefs(prefManager: PrefsManager, dataLogin: DataLogin) {
        prefManager.prefsIsLogin = true
        prefManager.prefsUsername = dataLogin.username!!
        prefManager.prefsNamalengkap = dataLogin.namalengkap!!
        prefManager.prefsAlamat = dataLogin.alamat!!
        prefManager.prefsRole = dataLogin.role!!
        prefManager.prefsIsActive = dataLogin.isActive!!
    }

}
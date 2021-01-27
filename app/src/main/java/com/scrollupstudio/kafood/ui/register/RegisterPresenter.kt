package com.scrollupstudio.kafood.ui.register

import android.widget.Toast
import com.scrollupstudio.kafood.data.model.register.RegisterResponse
import com.scrollupstudio.kafood.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter (val view: RegisterContract.View): RegisterContract.Presenter{

    init {
        view.initActivity()
        view.initListener()
        view.onLoading(false)
    }

    override fun register(id_user: String, username: String, password: String) {
        view.onLoading(true)
        ApiService.auth.register(id_user, username, password)
            .enqueue(object : Callback<RegisterResponse>{
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    view.onLoading(false)
                    view.onMessage(t.message.toString())
                }

                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    view.onLoading(false)
                    if (response.isSuccessful){
                        val registerResponse: RegisterResponse? = response.body()
                        view.onResult(registerResponse!!)
                    }else{
                        view.onMessage("Ada salah coy")
                    }
                }

            })
    }

}



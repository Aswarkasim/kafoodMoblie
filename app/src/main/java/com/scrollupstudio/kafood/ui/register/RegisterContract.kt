package com.scrollupstudio.kafood.ui.register

import com.scrollupstudio.kafood.data.model.register.RegisterResponse

interface RegisterContract {

    interface Presenter{
        fun register(
            id_user: String,
            username: String,
            password: String
        )
    }

    interface View{
        fun initActivity()
        fun initListener()
        fun onLoading(loading: Boolean)
        fun onResult(registerResponse: RegisterResponse)
        fun onMessage(message: String)
    }
}
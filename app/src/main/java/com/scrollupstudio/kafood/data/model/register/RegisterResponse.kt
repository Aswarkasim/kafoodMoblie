package com.scrollupstudio.kafood.data.model.register

data class RegisterResponse(
    val error: Boolean,
    val message: String,
    val status: String,
    val user: DataRegister
)
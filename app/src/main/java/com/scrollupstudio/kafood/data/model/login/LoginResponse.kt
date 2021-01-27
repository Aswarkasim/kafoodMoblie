package com.scrollupstudio.kafood.data.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("user")
	val user: DataLogin? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataLogin(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("is_active")
	val isActive: String? = null,

	@field:SerializedName("date_updated")
	val dateUpdated: String? = null,

	@field:SerializedName("no_hp")
	val noHp: String? = null,

	@field:SerializedName("date_created")
	val dateCreated: String? = null,

	@field:SerializedName("namalengkap")
	val namalengkap: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("id_user")
	val idUser: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)

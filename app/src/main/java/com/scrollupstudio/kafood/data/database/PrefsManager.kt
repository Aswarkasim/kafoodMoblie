package com.scrollupstudio.kafood.data.database

import android.content.Context
import android.content.SharedPreferences
import hu.autsoft.krate.Krate
import hu.autsoft.krate.booleanPref
import hu.autsoft.krate.stringPref

class PrefsManager (context: Context): Krate{

    private val PREFS_ON_BOARDING: String = "prefs_on_boarding"
    private val PREFS_IS_LOGIN: String = "prefs_is_login"
    private val PREFS_USERNAME: String = "prefs_username"
    private val PREFS_PASSWORD: String = "prefs_password"
    private val PREFS_ALAMAT: String = "prefs_alamat"
    private val PREFS_NAMALENGKAP: String = "prefs_namalengkap"
    private val PREFS_ROLE: String = "prefs_role"
    private val PREFS_IS_ACTIVE: String = "prefs_is_active"

    override val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.applicationContext.getSharedPreferences(
            "scrollupstudio_kafood_prefs123456", Context.MODE_PRIVATE
        )
    }

    var prefsIsLogin by booleanPref(PREFS_IS_LOGIN, false)
    var prefsUsername by stringPref(PREFS_USERNAME, "")
    var prefsPassword by stringPref(PREFS_PASSWORD, "")
    var prefsAlamat by stringPref(PREFS_ALAMAT, "")
    var prefsNamalengkap by stringPref(PREFS_NAMALENGKAP, "")
    var prefsRole by stringPref(PREFS_ROLE, "")
    var prefsIsActive by stringPref(PREFS_IS_ACTIVE, "")

    fun logout(){
        sharedPreferences.edit().clear().apply()
    }
}
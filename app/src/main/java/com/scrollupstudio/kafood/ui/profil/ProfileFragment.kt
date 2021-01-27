package com.scrollupstudio.kafood.ui.profil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.scrollupstudio.kafood.R
import com.scrollupstudio.kafood.data.database.PrefsManager
import com.scrollupstudio.kafood.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.startActivity
import kotlin.random.Random


class ProfileFragment : Fragment() {


    private lateinit var prefsManager: PrefsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        prefsManager = PrefsManager(view.context)

        btn_logout_profile.setOnClickListener {
            prefsManager.logout()
            view.context.startActivity<LoginActivity>()
        }
    }


}
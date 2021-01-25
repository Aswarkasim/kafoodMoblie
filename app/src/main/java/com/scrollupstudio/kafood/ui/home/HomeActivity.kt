package com.scrollupstudio.kafood.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.scrollupstudio.kafood.R
import com.scrollupstudio.kafood.ui.cart.CartFragment
import com.scrollupstudio.kafood.ui.profil.ProfileFragment
import com.scrollupstudio.kafood.ui.transaksi.TransaksiFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        btnNavHome.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.action_home -> {
                    openFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.action_cart-> {
                    openFragment(CartFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_transaction ->{
                    openFragment(TransaksiFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_profile_user ->{
                    openFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
        btnNavHome.selectedItemId = R.id.action_home
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameHome, fragment)
            .addToBackStack(null)
            .commit()
    }
}
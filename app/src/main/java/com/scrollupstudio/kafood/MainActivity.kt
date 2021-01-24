package com.scrollupstudio.kafood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.scrollupstudio.kafood.ui.order.OrderFragment
import com.scrollupstudio.kafood.ui.produk.ProdukFragment
import com.scrollupstudio.kafood.ui.profil.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        btnNavMain.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.action_order->{
                    openFragment(OrderFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.action_product -> {
                    openFragment(ProdukFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_profile -> {
                    openFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
        btnNavMain.selectedItemId = R.id.action_order

    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameMain, fragment)
            .addToBackStack(null)
            .commit()
    }

}
package com.loodos.cryptoapp.ui


import android.view.LayoutInflater
import android.widget.Toast
import com.loodos.cryptoapp.base.BaseActivity
import com.loodos.cryptoapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getActivityBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }


    override fun onBackPressed() {
        super.onBackPressed()

        val count = supportFragmentManager.backStackEntryCount

        println("asd")
    }

}
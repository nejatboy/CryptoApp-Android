package com.loodos.cryptoapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.loodos.cryptoapp.base.BaseActivity
import com.loodos.cryptoapp.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getActivityBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = (supportFragmentManager.fragments[0] as NavHostFragment).navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }


    fun hideBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.GONE
    }


    fun showBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}
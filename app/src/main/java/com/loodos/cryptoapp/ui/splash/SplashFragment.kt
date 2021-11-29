package com.loodos.cryptoapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentSplashBinding
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.ui.MainActivity


class SplashFragment: BasePrimaryFragmentHasViewModel<MainActivity, FragmentSplashBinding, SplashViewModel>() {

    override fun prepareFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }


    override fun prepareViewModel(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel.coins.observe(viewLifecycleOwner, ::coinsFetched)

        //viewModel.requestFetchCoins()

        val action = SplashFragmentDirections.actionSplashFragmentToCryptoFragment()
        navController().navigate(action)
    }


    private fun coinsFetched(coins: ArrayList<Coin>) {
        viewModel.storeInRoomDatabase(coins)

        val action = SplashFragmentDirections.actionSplashFragmentToCryptoFragment()
        navController().navigate(action)
    }
}
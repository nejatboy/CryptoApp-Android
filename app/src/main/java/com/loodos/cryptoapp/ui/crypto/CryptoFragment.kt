package com.loodos.cryptoapp.ui.crypto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentCryptoBinding
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.ui.MainActivity


class CryptoFragment: BasePrimaryFragmentHasViewModel<MainActivity, FragmentCryptoBinding, CryptoViewModel>() {

    override fun prepareFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentCryptoBinding {
        return FragmentCryptoBinding.inflate(inflater, container, false)
    }


    override fun prepareViewModel(): Class<CryptoViewModel> {
        return CryptoViewModel::class.java
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchBar.queryListener = ::searched
        binding.recyclerView.adapter().itemClickListener = ::itemCoinClicked

        viewModel.coins.observe(viewLifecycleOwner, ::observeSearchedCoins)
    }


    private fun searched(query: String) {
        if (query.isEmpty()) {
            binding.recyclerView.adapter().setCoins(newCoins = arrayListOf())
            return
        }

        viewModel.findCoinsInRoomDatabase(search = query)
    }


    private fun observeSearchedCoins(coins: List<Coin>) {
        binding.recyclerView.adapter().setCoins(coins)
    }


    private fun itemCoinClicked(coin: Coin) {
        val action = CryptoFragmentDirections.actionCryptoFragmentToDetailFragment(coin, false)
        navController().navigate(action)
    }
}
package com.loodos.cryptoapp.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentDetailBinding
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.models.CoinDetail
import com.loodos.cryptoapp.ui.MainActivity


class DetailFragment: BasePrimaryFragmentHasViewModel<MainActivity, FragmentDetailBinding, DetailViewModel>() {

    override fun prepareFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }


    override fun prepareViewModel(): Class<DetailViewModel> {
        return DetailViewModel::class.java
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity().hideBottomNavigationView()

        viewModel.fireStoreService.messageListener = ::showMessage

        binding.buttonAddFavourite.visibility = View.VISIBLE

        binding.buttonAddFavourite.visibility = if (isComeFromProfileFragment()) View.GONE else View.VISIBLE
        binding.buttonAddFavourite.setOnClickListener(::buttonAddFavouritesClicked)

        getCoinFromBundle()?.let {  coin->
            showProgress()
            viewModel.requestFetchCoinDetails(coinId = coin.id)
        }

        viewModel.coinDetail.observe(viewLifecycleOwner, ::observeCoinDetail)
        viewModel.coinInFavourites.observe(viewLifecycleOwner, ::observeCoinInFavourites)
    }


    private fun getCoinFromBundle() : Coin? {
        val arguments = arguments ?: return null
        return DetailFragmentArgs.fromBundle(arguments).coin
    }


    private fun isComeFromProfileFragment() : Boolean {
        val arguments = arguments ?: return false
        return DetailFragmentArgs.fromBundle(arguments).isComeFromProfile
    }


    private fun buttonAddFavouritesClicked(button: View) {
        viewModel.getFirebaseUser() ?: run {
            val action = DetailFragmentDirections.actionDetailFragmentToProfileFragment()
            navController().navigate(action)
            return
        }

        getCoinFromBundle()?.let {  coin->
            showProgress()
            viewModel.requestSaveToFavourites(coin)
        }
    }


    @SuppressLint("CheckResult")
    private fun observeCoinDetail(coinDetail: CoinDetail) {
        hideProgress()

        binding.apply {
            textViewCoinName.text = coinDetail.name
            textViewCoinPrice.text = "${coinDetail.marketData?.currentPrice ?: "-"}"
            Glide.with(this@DetailFragment).load(coinDetail.image?.large).into(binding.imageViewCoin)
        }
    }


    private fun observeCoinInFavourites(coin: Coin) {
        binding.buttonAddFavourite.visibility = View.GONE
        showMessage("Coin added to favourites.")
    }


    override fun onDestroyView() {
        activity().showBottomNavigationView()
        super.onDestroyView()
    }
}
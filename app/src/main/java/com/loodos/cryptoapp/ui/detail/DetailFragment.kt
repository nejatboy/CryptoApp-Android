package com.loodos.cryptoapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentDetailBinding
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

        bindCoin()

        binding.buttonAddFavourite.setOnClickListener {
            val firebaseUser = viewModel.getFirebaseUser() ?: run {
                val action = DetailFragmentDirections.actionDetailFragmentToLoginFragment()
                navController().navigate(action)
                return@setOnClickListener
            }

            val action = DetailFragmentDirections.actionDetailFragmentToLoginFragment()
            navController().navigate(action)
        }
    }


    private fun bindCoin() {
        val arguments = arguments ?: return
        val coin = DetailFragmentArgs.fromBundle(arguments).selectedCoin

        println("asd")

        /*binding.imageView.loadUrl(movie.getImageUrl(isPosterPath = false))
        binding.layoutImdb.textViewPoint.text = "${movie.voteAverage}/10"
        binding.layoutImdb.textViewDate.text = movie.releaseDate
        binding.textViewTitle.text = movie.getTitle
        binding.textViewDescription.text = movie.overview*/
    }

}
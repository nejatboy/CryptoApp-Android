package com.loodos.cryptoapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseUser
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentProfileBinding
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.ui.MainActivity


class ProfileFragment: BasePrimaryFragmentHasViewModel<MainActivity, FragmentProfileBinding, ProfileViewModel>() {

    override fun prepareFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }


    override fun prepareViewModel(): Class<ProfileViewModel> {
        return ProfileViewModel::class.java
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.authService.messageListener = ::showMessage
        viewModel.fireStoreService.messageListener = ::showMessage

        val isLoggedInUser = viewModel.requestGetCurrentUser() != null

        if (isLoggedInUser) {
            binding.layoutLogin.root.visibility = View.GONE
            viewModel.requestFetchFavouriteCoins()
        }

        else {
            binding.layoutLogin.root.visibility = View.VISIBLE
        }

        binding.layoutLogin.buttonLogin.setOnClickListener(::buttonLoginClicked)
        binding.recyclerView.adapter().itemClickListener = ::onItemCoinClicked

        viewModel.firebaseUser.observe(viewLifecycleOwner, ::loggedIn)
        viewModel.favouriteCoins.observe(viewLifecycleOwner, ::observeFavouriteCoins)
    }


    private fun buttonLoginClicked(button: View) {
        val email = binding.layoutLogin.editTextEmail.text.toString()
        val password = binding.layoutLogin.editTextPassword.toString()

        viewModel.requestLogin(email, password)
        showProgress()
    }


    private fun loggedIn(firebaseUser: FirebaseUser) {
        hideProgress()
        binding.layoutLogin.root.visibility = View.GONE
    }


    private fun observeFavouriteCoins(coins: ArrayList<Coin>) {
        binding.recyclerView.adapter().setCoins(coins)
    }


    private fun onItemCoinClicked(coin: Coin) {
        val action = ProfileFragmentDirections.actionProfileFragmentToDetailFragment(coin, true)
    }
}
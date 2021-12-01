package com.loodos.cryptoapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseUser
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentProfileBinding
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

        binding.layoutLogin.root.visibility = if (viewModel.requestGetCurrentUser() != null) View.GONE else View.VISIBLE
        binding.layoutLogin.buttonLogin.setOnClickListener(::buttonLoginClicked)

        viewModel.authService.messageListener = ::showMessage
        viewModel.firebaseUser.observe(viewLifecycleOwner, ::loggedIn)
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
}
package com.loodos.cryptoapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        viewModel.authService.messageListener = ::showMessage

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.toString()

            viewModel.requestLogin(email, password)
        }
    }

}
package com.loodos.cryptoapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragment
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentLoginBinding
import com.loodos.cryptoapp.ui.MainActivity

class LoginFragment: BasePrimaryFragmentHasViewModel<MainActivity, FragmentLoginBinding, LoginViewModel>() {

    override fun prepareFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }



    override fun prepareViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
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
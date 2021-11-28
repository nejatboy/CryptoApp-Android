package com.loodos.cryptoapp.ui.crypto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragmentHasViewModel
import com.loodos.cryptoapp.databinding.FragmentCryptoBinding
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


    }
}
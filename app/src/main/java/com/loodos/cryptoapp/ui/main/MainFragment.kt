package com.loodos.cryptoapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.loodos.cryptoapp.base.fragment.BasePrimaryFragment
import com.loodos.cryptoapp.databinding.FragmentMainBinding
import com.loodos.cryptoapp.ui.MainActivity

class MainFragment: BasePrimaryFragment<MainActivity, FragmentMainBinding>() {

    override fun prepareFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }
}
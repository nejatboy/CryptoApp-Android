package com.loodos.cryptoapp.base.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.loodos.cryptoapp.base.BaseActivity
import com.loodos.cryptoapp.base.BaseViewModel


abstract class BasePrimaryFragmentHasViewModel<A: BaseActivity<*>, VB: ViewBinding, VM: BaseViewModel>: BasePrimaryFragment<A, VB>() {

    protected lateinit var viewModel: VM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(prepareViewModel())
    }


    abstract fun prepareViewModel() : Class<VM>
}

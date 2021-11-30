package com.loodos.cryptoapp.base.fragment

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.loodos.cryptoapp.base.BaseActivity
import com.loodos.cryptoapp.base.BaseViewModel

abstract class BaseSecondaryFragmentHasViewModel<A: BaseActivity<*>, VB: ViewBinding, VM: BaseViewModel, PF: Fragment>: BasePrimaryFragmentHasViewModel<A, VB, VM>() {

    @Suppress("UNCHECKED_CAST")
    protected fun primaryFragment() : PF {
        return parentFragment?.parentFragment as PF
    }
}
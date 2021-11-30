package com.loodos.cryptoapp.base.fragment


import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.loodos.cryptoapp.base.BaseActivity



abstract class BaseSecondaryFragment<A: BaseActivity<*>, VB: ViewBinding, PF: Fragment>: BasePrimaryFragment<A, VB>() {

    @Suppress("UNCHECKED_CAST")
    protected fun primaryFragment() : PF {
        return parentFragment?.parentFragment as PF
    }

}
package com.loodos.cryptoapp.base.fragment

import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.viewbinding.ViewBinding
import com.loodos.cryptoapp.base.BaseActivity

abstract class BasePrimaryFragment<A: BaseActivity<*>, VB: ViewBinding>: BaseFragment<A, VB>() {

    protected fun navController(): NavController {
        return (parentFragment as NavHost).navController
    }
}
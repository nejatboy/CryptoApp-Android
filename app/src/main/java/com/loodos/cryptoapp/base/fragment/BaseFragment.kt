package com.loodos.cryptoapp.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.viewbinding.ViewBinding
import com.loodos.cryptoapp.base.BaseActivity

abstract class BaseFragment<A: BaseActivity<*>, VB: ViewBinding>: Fragment() {

    protected lateinit var binding: VB


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = getFragmentBinding(inflater, container)
        return binding.root
    }


    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) : VB


    @Suppress("UNCHECKED_CAST")
    protected fun activity() : A {
        return activity as A
    }


    fun navController(): NavController {
        return (parentFragment as NavHost).navController
    }
}
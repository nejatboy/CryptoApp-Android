package com.loodos.cryptoapp.base.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.loodos.cryptoapp.base.BaseActivity
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.repository.BaseRepository
import com.loodos.cryptoapp.services.RemoteDataSource
import com.loodos.cryptoapp.util.ViewModelFactory

abstract class BasePrimaryFragmentHasViewModel<A: BaseActivity<*>, VB: ViewBinding, VM: BaseViewModel, R: BaseRepository>: BaseFragment<A, VB>() {

    protected val remoteDataSource = RemoteDataSource()
    protected lateinit var viewModel: VM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
    }


    abstract fun getViewModel() : Class<VM>


    abstract fun getFragmentRepository() : R
}
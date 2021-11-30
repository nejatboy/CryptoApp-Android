package com.loodos.cryptoapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected lateinit var binding: VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = getActivityBinding(layoutInflater)
        setContentView(binding.root)
    }


    abstract fun getActivityBinding(inflater: LayoutInflater) : VB


    fun showMessage(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
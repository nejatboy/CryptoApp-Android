package com.loodos.cryptoapp.base.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerViewAdapter<VDB: ViewDataBinding>(private val layoutID: Int): RecyclerView.Adapter<BaseRecyclerViewAdapter<VDB>.Holder>() {

    inner class Holder(cell: VDB) : BaseRecyclerViewHolder<VDB>(cell)

    var itemClickListener: ((coinId: String) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<VDB>(inflater, layoutID, parent, false)
        return Holder(binding)
    }
}
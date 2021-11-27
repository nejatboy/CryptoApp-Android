package com.loodos.cryptoapp.base.recyclerView

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder<VDB: ViewDataBinding>(cell: VDB): RecyclerView.ViewHolder(cell.root) {

    fun binding() : VDB {
        return DataBindingUtil.findBinding(itemView)!!
    }

}
package com.loodos.cryptoapp.base.recyclerView

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearSnapHelper

abstract class BaseRecyclerViewHasSnapHelper<VDB: ViewDataBinding, A: BaseRecyclerViewAdapter<VDB>>:
    BaseRecyclerView<VDB, A> {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    init {
        val linearSnapHelper = LinearSnapHelper()
        linearSnapHelper.attachToRecyclerView(this)
    }
}
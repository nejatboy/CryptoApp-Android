package com.loodos.cryptoapp.ui.login

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loodos.cryptoapp.base.recyclerView.BaseRecyclerView
import com.loodos.cryptoapp.databinding.CellProfileBinding
import com.loodos.cryptoapp.ui.crypto.CryptoAdapter
import com.loodos.cryptoapp.util.Device.widthRatio

class ProfileRecyclerView: BaseRecyclerView<CellProfileBinding, ProfileAdapter> {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    init {
        adapter = ProfileAdapter()
        layoutManager = LinearLayoutManager(context)
        addItemDecoration(Decoration())
    }


    private class Decoration: ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
            super.getItemOffsets(outRect, view, parent, state)

            val margin = 0.05f.widthRatio

            outRect.top = margin
            outRect.left = margin
            outRect.right = margin
        }
    }
}
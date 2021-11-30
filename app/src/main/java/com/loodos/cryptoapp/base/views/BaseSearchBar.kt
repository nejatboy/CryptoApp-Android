package com.loodos.cryptoapp.base.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.SearchView

abstract class BaseSearchBar: SearchView, SearchView.OnQueryTextListener {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var queryListener: ((query: String) -> Unit)? = null


    init {
        this.setOnQueryTextListener(this)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        val query = newText ?: return true
        queryListener?.invoke(query)
        return true
    }
}
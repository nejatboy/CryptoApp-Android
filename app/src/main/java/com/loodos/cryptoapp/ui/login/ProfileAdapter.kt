package com.loodos.cryptoapp.ui.login

import com.loodos.cryptoapp.R
import com.loodos.cryptoapp.base.recyclerView.BaseRecyclerViewAdapter
import com.loodos.cryptoapp.databinding.CellProfileBinding
import com.loodos.cryptoapp.models.Coin

class ProfileAdapter: BaseRecyclerViewAdapter<CellProfileBinding>(R.layout.cell_profile) {

    private val coins = ArrayList<Coin>()


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val coin = coins[position]
        holder.binding().coin = coin
    }

    override fun getItemCount(): Int {
        return coins.size
    }
}
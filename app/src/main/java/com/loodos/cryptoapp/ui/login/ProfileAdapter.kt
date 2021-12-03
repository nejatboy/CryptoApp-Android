package com.loodos.cryptoapp.ui.login

import android.annotation.SuppressLint
import com.loodos.cryptoapp.R
import com.loodos.cryptoapp.base.recyclerView.BaseRecyclerViewAdapter
import com.loodos.cryptoapp.databinding.CellProfileBinding
import com.loodos.cryptoapp.models.Coin

class ProfileAdapter: BaseRecyclerViewAdapter<CellProfileBinding>(R.layout.cell_profile) {

    private var coins: List<Coin> = arrayListOf()


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val coin = coins[position]
        holder.binding().coin = coin
    }

    override fun getItemCount(): Int {
        return coins.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setCoins(newCoins: List<Coin>) {
        coins = newCoins
        notifyDataSetChanged()
    }
}
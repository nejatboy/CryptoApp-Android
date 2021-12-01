package com.loodos.cryptoapp.ui.crypto

import android.annotation.SuppressLint
import com.loodos.cryptoapp.R
import com.loodos.cryptoapp.base.recyclerView.BaseRecyclerViewAdapter
import com.loodos.cryptoapp.databinding.CellCryptoBinding
import com.loodos.cryptoapp.models.Coin

class CryptoAdapter: BaseRecyclerViewAdapter<CellCryptoBinding>(R.layout.cell_crypto) {

    private var coins: List<Coin> = arrayListOf()


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val coin = coins[position]
        holder.binding().coin = coin

        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(coin.id)
        }
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
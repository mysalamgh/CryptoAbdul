package com.example.cryptoabdul.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.cryptoabdul.databinding.ListItemCurrencyInfoBinding
import com.example.cryptoabdul.model.CurrencyInfo
import com.example.cryptoabdul.ui.CurrencyInfoItemViewHolder
import com.example.cryptoabdul.viewmodel.CurrencyInfoViewModel

class CurrencyInfoItemAdapter(
    private val currencyInfoViewModel: CurrencyInfoViewModel
) :
    ListAdapter<CurrencyInfo, CurrencyInfoItemViewHolder>(
        BanItemDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyInfoItemViewHolder {
        return CurrencyInfoItemViewHolder(
            currencyInfoViewModel,
            ListItemCurrencyInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CurrencyInfoItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateList(list: List<CurrencyInfo>) {
        submitList(list)
    }
}

private class BanItemDiffCallback : DiffUtil.ItemCallback<CurrencyInfo>() {

    override fun areItemsTheSame(
        oldItem: CurrencyInfo,
        newItem: CurrencyInfo
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CurrencyInfo,
        newItem: CurrencyInfo
    ): Boolean {
        return oldItem == newItem
    }
}
package com.example.cryptoabdul.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoabdul.databinding.ListItemCurrencyInfoBinding
import com.example.cryptoabdul.model.CurrencyInfo
import com.example.cryptoabdul.viewmodel.CurrencyInfoViewModel

class CurrencyInfoItemViewHolder(
    private val currencyInfoViewModel: CurrencyInfoViewModel,
    private val binding: ListItemCurrencyInfoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CurrencyInfo) {
        binding.apply {
            iconTextView.text = item.name.first().toString()
            nameTextView.text = item.name
            symbolTextView.text = item.symbol
            rootLayout.setOnClickListener {
                currencyInfoViewModel.setSelectedCurrencyInfo(item)
            }
        }
    }
}